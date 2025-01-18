import java.lang.String;
import java.util.Collection;

public class CampaignEventRepository {
    public interface CampaignRepository {
        void addPersonWithEvents(long id, Collection<Event> events); // You will implement SQL query here
    }

    public static void main(String[] args) {
    }
}

class Event {
    // minimal class definition
}