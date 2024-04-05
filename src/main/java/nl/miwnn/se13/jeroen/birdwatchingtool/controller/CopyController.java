package nl.miwnn.se13.jeroen.birdwatchingtool.controller;

import nl.miwnn.se13.jeroen.birdwatchingtool.model.Bird;
import nl.miwnn.se13.jeroen.birdwatchingtool.model.Copy;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.BirdRepository;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Jeroen van der Weide
 * <p>
 * Handle all requests regarding copies of birds
 **/

@Controller
public class CopyController {
    private final BirdRepository birdRepository;
    private final CopyRepository copyRepository;

    public CopyController(BirdRepository birdRepository, CopyRepository copyRepository) {
        this.birdRepository = birdRepository;
        this.copyRepository = copyRepository;
    }

    @GetMapping("/copy/new/{birdSpecies}")
    private String createNewCopy(@PathVariable("birdSpecies") String birdSpecies) {
        Optional<Bird> optionalBird = birdRepository.findByBirdSpecies(birdSpecies);

        if (optionalBird.isPresent()){
            Copy copy = new Copy();
            copy.setBird(optionalBird.get());
            copyRepository.save(copy);
        }

        return "redirect:/";
    }

}
