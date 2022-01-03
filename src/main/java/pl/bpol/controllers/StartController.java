package pl.bpol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.bpol.model.GamesPlayed;
import pl.bpol.model.Player;
import pl.bpol.repository.GamesRepo;
import pl.bpol.service.GameService;
import pl.bpol.service.PlayerService;

import java.util.List;

@Controller
@SessionAttributes({"name","incorrectName","hello"})
public class StartController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private GamesRepo gamesRepo;
    
    @RequestMapping("/")
    public String hello() {
    	return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String sendName(String name, ModelMap modelMap){
    	List<Player> players = playerService.getPlayers();
    	if(name.equals("")){
			modelMap.addAttribute("incorrectName", "Nie podano imienia");
			return "index";
    	}
        if(!(name.matches("[a-zA-Z0-9\\s]+"))) {
            modelMap.addAttribute("incorrectName", "Imię może się składać tylko z cyfr oraz liter (bez polskich znaków)");
            return "index";
        }
        if (name.length() > 30) {
            modelMap.addAttribute("incorrectName", "Imię nie może być dłuższe niż 30 znaków");
            return "index";
        }
    	for(Player player: players) {
    		if(player.getName().equals(name)) {
    			modelMap.addAttribute("incorrectName", "Imię zajęte, wybierz inne");
    			return "index";
    		}
    	}
        Player player = playerService.createPlayer(name);
        modelMap.addAttribute("name",player.getName());
        return "redirect:gameslist";
    }

    @RequestMapping(value = "gameslist")
    public String showGames(ModelMap modelMap){
        modelMap.put("games",gameService.getGames());
        modelMap.put("gamesPlayed", gamesRepo.findAll());
        return "gameslist";
    }

    @RequestMapping(value = "newgame")
    public String newGame(ModelMap modelMap){
        gameService.addGameByPlayerName(modelMap.get("name").toString());
        return "redirect:game/"+modelMap.get("name");
    }


}