package nl.miwnn.se13.jeroen.birdwatchingtool.repositories;


import nl.miwnn.se13.jeroen.birdwatchingtool.model.BirdFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdFoodRepository extends JpaRepository<BirdFood, Long> {
}
