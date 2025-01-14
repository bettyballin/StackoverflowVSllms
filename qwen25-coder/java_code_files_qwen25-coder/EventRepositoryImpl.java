// Necessary imports
import java.util.List;
import java.util.Optional;

// Interfaces and classes needed for compilation
interface EventRepository {
    void add(Event event);

    static EventRepository getInstance() {
        return new EventRepositoryImpl(new EventDataMapper());
    }
}

interface EventDataMapper {
    void insert(Event event);
}

interface Event {
    Optional<String> getId();
}

interface CampaignRepository {
    void save(Campaign campaign);
}

interface CampaignDataMapper {
    void update(Campaign campaign);
}

interface Campaign {
    List<Event> getEvents();
}

// Implementations of the interfaces
class EventDataMapperImpl implements EventDataMapper {
    @Override
    public void insert(Event event) {
        // Implementation here...
    }
}

class EventImpl implements Event {
    private Optional<String> id = Optional.empty();

    @Override
    public Optional<String> getId() {
        return id;
    }
}

class CampaignDataMapperImpl implements CampaignDataMapper {
    @Override
    public void update(Campaign campaign) {
        // Implementation here...
    }
}

class CampaignImpl implements Campaign {
    private List<Event> events;

    public CampaignImpl(List<Event> events) {
        this.events = events;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }
}

// Removed 'public' to comply with Java's single public class per file rule
class EventRepositoryImpl implements EventRepository {
    private final EventDataMapper dataMapper;

    public EventRepositoryImpl(EventDataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    @Override
    public void add(Event event) {
        dataMapper.insert(event);
    }

    // other CRUD operations...
}

public class CampaignRepositoryImpl implements CampaignRepository {
    private final CampaignDataMapper campaignDataMapper;

    public CampaignRepositoryImpl(CampaignDataMapper campaignDataMapper) {
        this.campaignDataMapper = campaignDataMapper;
    }

    @Override
    public void save(Campaign campaign) {
        // Save the campaign to the database
        campaignDataMapper.update(campaign);

        // Save associated events
        for (Event event : campaign.getEvents()) {
            if (!event.getId().isPresent()) {
                EventRepository.getInstance().add(event);
            }
        }
    }

    // other CRUD operations...

    public static void main(String[] args) {
        // Example usage
        EventDataMapper eventDataMapper = new EventDataMapperImpl();
        EventRepository eventRepository = new EventRepositoryImpl(eventDataMapper);

        CampaignDataMapper campaignDataMapper = new CampaignDataMapperImpl();
        CampaignRepository campaignRepository = new CampaignRepositoryImpl(campaignDataMapper);

        Event event = new EventImpl();
        Campaign campaign = new CampaignImpl(List.of(event));

        campaignRepository.save(campaign);
    }
}