package nl.miwnn.se13.jeroen.birdwatchingtool.controller;

import nl.miwnn.se13.jeroen.birdwatchingtool.model.Bird;
import nl.miwnn.se13.jeroen.birdwatchingtool.model.BirdFood;
import nl.miwnn.se13.jeroen.birdwatchingtool.model.Copy;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.BirdFoodRepository;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.BirdRepository;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jeroen van der Weide
 * <p>
 * Set some initial data in the database for testing purposes
 **/

@Controller
public class InitializeController {
    private final BirdFoodRepository birdFoodRepository;
    private  final BirdRepository birdRepository;
    private final CopyRepository copyRepository;

    public InitializeController(BirdFoodRepository birdFoodRepository,
                                BirdRepository birdRepository,
                                CopyRepository copyRepository) {
        this.birdFoodRepository = birdFoodRepository;
        this.birdRepository = birdRepository;
        this.copyRepository = copyRepository;
    }

    @GetMapping("/initialize")
    private String initializeDB(){

        BirdFood sunflowerSeeds = makeBirdFood("Sunflower Seeds");
        BirdFood peanuts = makeBirdFood("Peanuts");
        BirdFood suetCakes = makeBirdFood("Suet Cake");
        BirdFood mealWorms = makeBirdFood("Mealworms");

        Bird eurasianJay = makeBird("Eurasian Jay","Garrulus",peanuts);
        Bird commonBlackbird = makeBird("Common Blackbird","Turdus",sunflowerSeeds);
        Bird houseSparrow = makeBird("House Sparrow", "Passer", suetCakes);
        Bird carrionCrow = makeBird("Carrion Crow", "Corvus", mealWorms);
        Bird greatTit = makeBird("Great tit","Parus",suetCakes);

        makeCopy(eurasianJay).setObservingDate(LocalDate.now(ZoneId.of("Europe/Amsterdam")));
        makeCopy(houseSparrow).setObservingDate(LocalDate.now(ZoneId.of("Europe/Amsterdam")));
        makeCopy(houseSparrow).setObservingDate(LocalDate.now(ZoneId.of("Europe/Amsterdam")));

        return "redirect:/";
    }

    private BirdFood makeBirdFood(String birdFoodName){
        BirdFood birdFood = new BirdFood();
        birdFood.setBirdFoodName(birdFoodName);
        birdFoodRepository.save(birdFood);
        return  birdFood;

    }

    private Bird makeBird(String species, String genus, BirdFood birdFood){
        Bird bird = new Bird();
        bird.setBirdSpecies(species);
        bird.setBirdGenus(genus);

        Set<BirdFood> birdFoodSet = new HashSet<>();
        birdFoodSet.add(birdFood);
        bird.setBirdFoods(birdFoodSet);

        birdRepository.save(bird);
        return bird;

    }

    private Copy makeCopy(Bird bird){
        Copy copy = new Copy();
        copy.setBird(bird);
        copyRepository.save(copy);
        return copy;

    }

}

