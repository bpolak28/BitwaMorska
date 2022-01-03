package pl.bpol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bpol.model.GamesPlayed;

@Repository
public interface GamesRepo extends JpaRepository<GamesPlayed, Long> {
}
