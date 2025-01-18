import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
public class PlaceDto {

    @ManyToOne(targetEntity = EventDto.class,
      cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "EVENTS_PLACE",
        joinColumns = @JoinColumn(name = "PLACE_ID"),
        inverseJoinColumns = @JoinColumn(name = "EVENT_ID")
    )
    private List<EventDto> events;

    // Constructors, getters, setters, etc.
}

@Entity
class EventDto {
    // Define fields, constructors, getters, setters, etc.
}