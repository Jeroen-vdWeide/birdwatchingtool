package nl.miwnn.se13.jeroen.birdwatchingtool.controller;


import nl.miwnn.se13.jeroen.birdwatchingtool.model.Bird;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.BirdFoodRepository;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.BirdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


/**
 * @author Jeroen van der Weide
 * <p>
 * Handle all requests regarding birds
 **/

@Controller
public class BirdController {
    private final BirdFoodRepository birdFoodRepository;
    private final BirdRepository birdRepository;

    public BirdController(BirdFoodRepository birdFoodRepository, BirdRepository birdRepository) {
        this.birdFoodRepository = birdFoodRepository;
        this.birdRepository = birdRepository;
    }

    @GetMapping({"/", "/bird"})
    private String showBirdOverview(Model model) {

        model.addAttribute("allBirds", birdRepository.findAll());

        return "birdOverview";
    }

    @GetMapping("/bird/new")
    private String showBirdForm(Model model) {
        model.addAttribute("bird", new Bird());
        model.addAttribute("allBirdFood",birdFoodRepository.findAll());

        return "birdForm";
    }

    @PostMapping("/bird/new")
    private String saveBird(@ModelAttribute("bird") Bird birdToBeSaved, BindingResult result) {
        if (birdToBeSaved.getBirdId() == null
                && birdRepository.findByBirdSpecies(birdToBeSaved.getBirdSpecies()).isPresent()){
            return "redirect:/bird/new";
        }

        if (!result.hasErrors()) {
            birdRepository.save(birdToBeSaved);
        }

        return "redirect:/";
    }

    @GetMapping("/bird/edit/{birdSpecies}")
    private String showEditBirdForm(@PathVariable("birdSpecies") String birdSpecies, Model model){
        Optional<Bird> bird = birdRepository.findByBirdSpecies(birdSpecies);

        if (bird.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("bird", bird.get());
        model.addAttribute("allBirdFood",birdFoodRepository.findAll());

        return "birdForm";
    }




}
