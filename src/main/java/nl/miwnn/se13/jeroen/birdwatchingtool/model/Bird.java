package nl.miwnn.se13.jeroen.birdwatchingtool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


/**
 * @author Jeroen van der Weide
 * <p>
 * Represents a bird that can have specimens
 **/
@Entity
public class Bird {

    @Id @GeneratedValue
    private Long birdId;
    private String birdSpecies;
    private String birdGenus;

    public Bird(String birdSpecies, String birdGenus) {
        this.birdSpecies = birdSpecies;
        this.birdGenus = birdGenus;
    }

    public Bird() {

    }

    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Long birdId) {
        this.birdId = birdId;
    }

    public String getBirdSpecies() {
        return birdSpecies;
    }

    public void setBirdSpecies(String birdName) {
        this.birdSpecies = birdName;
    }

    public String getBirdGenus() {
        return birdGenus;
    }

    public void setBirdGenus(String birdFamily) {
        this.birdGenus = birdFamily;
    }
}
