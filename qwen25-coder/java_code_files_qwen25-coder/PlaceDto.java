import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

@Entity
public class PlaceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other properties

    @ManyToMany(mappedBy = "places", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<EventDto> events = new HashSet<>();

    // Constructors

    public PlaceDto() {
        // Default constructor
    }

    // Getters and setters

    public Set<EventDto> getEvents() {
        return events;
    }

    public void setEvents(Set<EventDto> events) {
        this.events = events;
    }

    public void addEvent(EventDto event) {
        this.events.add(event);
        event.getPlaces().add(this);
    }

    public void removeEvent(EventDto event) {
        this.events.remove(event);
        event.getPlaces().remove(this);
    }

    public static void main(String[] args) {
    }
}

@Entity
class EventDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other properties

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_place",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private Set<PlaceDto> places = new HashSet<>();

    // Constructors

    public EventDto() {
        // Default constructor
    }

    // Getters and setters

    public Set<PlaceDto> getPlaces() {
        return places;
    }

    public void setPlaces(Set<PlaceDto> places) {
        this.places = places;
    }
}