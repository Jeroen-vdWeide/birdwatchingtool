package nl.miwnn.se13.jeroen.birdwatchingtool.repositories;

import nl.miwnn.se13.jeroen.birdwatchingtool.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BirdRepository extends JpaRepository<Bird, Long> {
    Optional<Bird> findByBirdSpecies(String birdSpecies);
}
