// Example of using Mockito framework for mocking

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {

    @Mock
    private CalendarService calendarService; // Mocked object

    @Test
    public void testSendReminders() {
        // Arrange
        NotificationService notificationService = new NotificationService();
        notificationService.setCalendarService(calendarService);

        Event mockEvent = new Event("Meeting", "10:00 AM");

        when(calendarService.getEvents()).thenReturn(Arrays.asList(mockEvent)); // Define behavior of the mock

        // Act
        String result = notificationService.sendReminders();

        // Assert
        assertEquals("Reminder sent for Meeting at 10:00 AM", result);
    }

    public static void main(String[] args) {
    }
}

// Event class
class Event {
    private String name;
    private String time;

    public Event(String name, String time) {
        this.name = name;
        this.time = time;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}

// CalendarService interface
interface CalendarService {
    List<Event> getEvents();
}

// NotificationService class
class NotificationService {
    private CalendarService calendarService;

    public NotificationService() {
        // Default constructor
    }

    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public String sendReminders() {
        List<Event> events = calendarService.getEvents();
        StringBuilder result = new StringBuilder();
        for (Event event : events) {
            // Logic to send reminder
            result.append("Reminder sent for ").append(event.getName()).append(" at ").append(event.getTime());
        }
        return result.toString();
    }
}