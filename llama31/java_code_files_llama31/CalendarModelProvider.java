/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;
import java.util.List;

public class CalendarModelProvider {
    public static void main(String[] stringArray) {
        Calendar calendar = new Calendar();
        calendar.setModel(new SimpleCalendarModel(){

            @Override
            public List<Event> getEvents(Date date, Date date2) {
                return null;
            }
        });
    }
}
