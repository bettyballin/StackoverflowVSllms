import java.util.List;
import java.util.ArrayList;

class Person {
    private String id;
    private String name;

    // getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Campaign {
    private String id;
    private String name;
    private List<Event> events = new ArrayList<>();

    public void attachPersonToCampaign(Person person) {
        for (Event event : generateEventsForPerson(person)) {
            this.events.add(event);
            // Notify repository to insert the event when saving
            EventRepository.getInstance().add(event);
        }
    }

    private List<Event> generateEventsForPerson(Person p) {
        // logic to generate events based on campaign rules and person data
        return new ArrayList<>();
    }

    public void save() {
        CampaignRepository.getInstance().save(this);
    }

    // getters, setters, and other methods
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Event {
    private String id;
    private String name;
    // other fields, constructors, getters, setters
    public Event() {}
    public Event(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

interface EventRepository {
    void add(Event event);
    // other CRUD operations...

    static EventRepository getInstance() {
        return new EventRepositoryImpl();
    }
}

class EventRepositoryImpl implements EventRepository {
    public void add(Event event) {
        // Implementation code
        System.out.println("Event added: " + event.getName());
    }
}

interface CampaignRepository {
    void save(Campaign campaign);
    // other CRUD operations...

    static CampaignRepository getInstance() {
        return new CampaignRepositoryImpl();
    }
}

class CampaignRepositoryImpl implements CampaignRepository {
    public void save(Campaign campaign) {
        // Implementation code
        System.out.println("Campaign saved: " + campaign.getName());
    }
}

public class MainApp {
    public static void main(String[] args) {
        Campaign campaign = new Campaign();
        campaign.setName("Test Campaign");

        Person person = new Person();
        person.setName("John Doe");

        campaign.attachPersonToCampaign(person);
        campaign.save();
    }
}