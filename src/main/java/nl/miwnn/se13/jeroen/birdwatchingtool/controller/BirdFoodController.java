package nl.miwnn.se13.jeroen.birdwatchingtool.controller;

import nl.miwnn.se13.jeroen.birdwatchingtool.model.BirdFood;
import nl.miwnn.se13.jeroen.birdwatchingtool.repositories.BirdFoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Jeroen van der Weide
 * <p>
 * Handle all requests regarding bird food
 **/
@Controller
public class BirdFoodController {
    private final BirdFoodRepository birdFoodRepository;

    public BirdFoodController(BirdFoodRepository birdFoodRepository) {
        this.birdFoodRepository = birdFoodRepository;
    }

    @GetMapping("/bird-food")
    private String showAllBirdFood(Model model){
        model.addAttribute("allBirdFood",birdFoodRepository.findAll());
        model.addAttribute("newBirdFood", new BirdFood());

        return "birdFoodOverview";
    }

    @PostMapping("/bird-food/new")
    private String saveOrUpdateBirdFood(@ModelAttribute("newBirdFood") BirdFood birdFood, BindingResult result){
        if (!result.hasErrors()) {
            birdFoodRepository.save(birdFood);
        }

        return "redirect:/bird-food";

    }

}
