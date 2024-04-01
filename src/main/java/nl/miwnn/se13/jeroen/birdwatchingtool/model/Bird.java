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
    private String birdName;
    private String birdFamily;

    public Bird(String birdName, String birdFamily) {
        this.birdName = birdName;
        this.birdFamily = birdFamily;
    }

    public Bird() {

    }

    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Long birdId) {
        this.birdId = birdId;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public String getBirdFamily() {
        return birdFamily;
    }

    public void setBirdFamily(String birdFamily) {
        this.birdFamily = birdFamily;
    }
}
