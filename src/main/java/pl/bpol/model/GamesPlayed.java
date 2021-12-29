package pl.bpol.model;

import java.util.Date;

public class GamesPlayed {

    String imieZwyciescy;

    String imiePrzegranego;

    Date dataGry;

    public GamesPlayed(String imieZ, String imieP) {
        this.dataGry = new Date();
        this.imieZwyciescy = imieZ;
        this.imiePrzegranego = imieP;
    }
}
