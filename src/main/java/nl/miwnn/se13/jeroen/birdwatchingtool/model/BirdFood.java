package nl.miwnn.se13.jeroen.birdwatchingtool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Jeroen van der Weide
 * <p>
 * Represents food used to attract certain birds
 **/

@Entity
public class BirdFood {

    @Id @GeneratedValue
    private long birdFoodId;

    private String birdFoodName;


    public long getBirdFoodId() {
        return birdFoodId;
    }

    public void setBirdFoodId(long birdFoodId) {
        this.birdFoodId = birdFoodId;
    }

    public String getBirdFoodName() {
        return birdFoodName;
    }

    public void setBirdFoodName(String birdFoodName) {
        this.birdFoodName = birdFoodName;
    }

    @Override
    public String toString() {
        return birdFoodName;
    }
}
