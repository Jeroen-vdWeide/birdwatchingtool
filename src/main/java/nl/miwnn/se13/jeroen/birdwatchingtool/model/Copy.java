package nl.miwnn.se13.jeroen.birdwatchingtool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author Jeroen van der Weide
 * <p>
 * A copy of a bird species that was observed at a certain date in the Netherlands
 **/

@Entity
public class Copy {
    @Id @GeneratedValue
    private Long copyId;

    private LocalDate observingDate = LocalDate.now(ZoneId.of("Europe/Amsterdam"));

    @ManyToOne
    private Bird bird;

    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }

    public LocalDate getObservingDate() {
        return observingDate;
    }

    public void setObservingDate(LocalDate observingDate) {
        this.observingDate = observingDate;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }
}
