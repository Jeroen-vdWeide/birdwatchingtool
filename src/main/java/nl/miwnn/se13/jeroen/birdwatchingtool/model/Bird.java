package nl.miwnn.se13.jeroen.birdwatchingtool.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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

    @Column(unique = true)
    private String birdSpecies;

    private String birdGenus;

    @ManyToMany
    private Set<BirdFood> birdFoods;

    @OneToMany(mappedBy = "bird")
    private List<Copy> copies;


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

    public Set<BirdFood> getBirdFoods() {
        return birdFoods;
    }

    public void setBirdFoods(Set<BirdFood> birdFoods) {
        this.birdFoods = birdFoods;
    }
}
