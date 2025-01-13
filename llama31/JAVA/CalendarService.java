import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

// Define the Event class
class Event {
    private String name;

    public Event(String name) {
        this.name = name;
    }
}

// Define the EventDAO interface
interface EventDAO {
    List<Event> getEvents();
}

// Class under test
public class CalendarService {
    private EventDAO eventDAO;

    public CalendarService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public List<Event> getEvents() {
        return eventDAO.getEvents();
    }

    // Test using Mockito
    public static class CalendarServiceTest {
        @Test
        public void testGetEvents() {
            // Create a mock EventDAO object
            EventDAO mockEventDAO = mock(EventDAO.class);

            // Define the behavior of the mock object
            when(mockEventDAO.getEvents()).thenReturn(Arrays.asList(new Event("Event 1"), new Event("Event 2")));

            // Create a CalendarService instance with the mock EventDAO
            CalendarService calendarService = new CalendarService(mockEventDAO);

            // Test the getEvents method
            List<Event> events = calendarService.getEvents();
            assertEquals(2, events.size());
        }
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalendarService.CalendarServiceTest");
    }
}