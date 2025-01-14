import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class EventDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other properties

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "EVENTS_PLACES",
        joinColumns = {@JoinColumn(name = "event_id")},
        inverseJoinColumns = {@JoinColumn(name = "place_id")}
    )
    private Set<PlaceDto> places;

    // Constructors, getters and setters

    public EventDto() {
        places = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Set<PlaceDto> getPlaces() {
        return places;
    }

    public void setPlaces(Set<PlaceDto> places) {
        this.places = places;
    }

    public void addPlace(PlaceDto place) {
        this.places.add(place);
        place.getEvents().add(this);
    }

    public void removePlace(PlaceDto place) {
        this.places.remove(place);
        place.getEvents().remove(this);
    }

    public static void main(String[] args) {
    }
}

@Entity
class PlaceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other properties

    @ManyToMany(mappedBy = "places")
    private Set<EventDto> events;

    // Constructors, getters and setters

    public PlaceDto() {
        events = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Set<EventDto> getEvents() {
        return events;
    }

    public void setEvents(Set<EventDto> events) {
        this.events = events;
    }

    public static void main(String[] args) {
    }
}