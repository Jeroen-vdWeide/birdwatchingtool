package nl.miwnn.se13.jeroen.birdwatchingtool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Jeroen van der Weide
 * <p>
 * Represents a bird species of a certain genus,
 * that can have multiple copies observed
 **/
@Entity
public class Bird {

    @Id @GeneratedValue
    private Long birdId;
    private String birdSpecies;
    private String birdGenus;

    @OneToMany(mappedBy = "bird")
    private List<Copy> copies;


    public Bird(String birdSpecies, String birdGenus) {
        this.birdSpecies = birdSpecies;
        this.birdGenus = birdGenus;
    }

    public Bird() {

    }

    public int getMostObservedCopiesInADay() {
        Map<LocalDate, Integer> observationsPerDay = new HashMap<>();


        for (Copy copy : copies) {
            LocalDate observationDate = copy.getObservingDate();
            observationsPerDay.put(observationDate,
                    observationsPerDay.getOrDefault(observationDate, 0) + 1);
        }


        int maxCount = 0;
        for (int count : observationsPerDay.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public int getTotalNumberOfCopies(){
        return copies.size();
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
