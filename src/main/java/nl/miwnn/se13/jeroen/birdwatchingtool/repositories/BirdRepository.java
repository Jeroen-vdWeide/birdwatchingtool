package nl.miwnn.se13.jeroen.birdwatchingtool.repositories;

import nl.miwnn.se13.jeroen.birdwatchingtool.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jeroen van der Weide
 **/
public interface BirdRepository extends JpaRepository<Bird, Long> {
}
