package nl.miwnn.se13.jeroen.birdwatchingtool.controller;


import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.BirdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author Jeroen van der Weide
 * <p>
 * Handle all requests regarding birds
 **/

@Controller
public class BirdController {
    private final BirdRepository birdRepository;

    public BirdController(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @GetMapping("/")
    private String showBirdOverview(Model model) {

        model.addAttribute("allBirds", birdRepository.findAll());

        return "birdOverview";
    }
}
