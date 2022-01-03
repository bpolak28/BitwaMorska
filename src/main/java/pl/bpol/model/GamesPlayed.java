package pl.bpol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class GamesPlayed {

    @Id
    @GeneratedValue
    private Long id;

    private String imieZwyciescy;

    private String imiePrzegranego;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dataGry;

    public GamesPlayed() {

    }

    public GamesPlayed(String imieZ, String imieP) {
        this.dataGry = LocalDate.now();
        this.imieZwyciescy = imieZ;
        this.imiePrzegranego = imieP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImieZwyciescy() {
        return imieZwyciescy;
    }

    public void setImieZwyciescy(String imieZwyciescy) {
        this.imieZwyciescy = imieZwyciescy;
    }

    public String getImiePrzegranego() {
        return imiePrzegranego;
    }

    public void setImiePrzegranego(String imiePrzegranego) {
        this.imiePrzegranego = imiePrzegranego;
    }

    public LocalDate getDataGry() {
        return dataGry;
    }

    public void setDataGry(LocalDate dataGry) {
        this.dataGry = dataGry;
    }
}
