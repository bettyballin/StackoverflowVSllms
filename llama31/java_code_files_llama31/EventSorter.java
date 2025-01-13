/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class EventSorter {
    public static List<Event> sort(List<Event> list) {
        ArrayList<Event> arrayList = new ArrayList<Event>();
        double d = 0.0;
        for (Event event : list) {
            int n;
            for (n = 0; n < arrayList.size() && ((Event)arrayList.get((int)n)).priority < event.priority; ++n) {
            }
            if (n == 0 || ((Event)arrayList.get((int)(n - 1))).earliestTime + ((Event)arrayList.get((int)(n - 1))).duration <= event.earliestTime) {
                arrayList.add(n, event);
            } else {
                for (n = 0; n < arrayList.size() && ((Event)arrayList.get((int)n)).earliestTime + ((Event)arrayList.get((int)n)).duration < event.earliestTime; ++n) {
                }
                arrayList.add(n, event);
            }
            if (arrayList.size() <= 0) continue;
            d = ((Event)arrayList.get((int)(arrayList.size() - 1))).earliestTime + ((Event)arrayList.get((int)(arrayList.size() - 1))).duration;
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        ArrayList<Event> arrayList = new ArrayList<Event>();
        arrayList.add(new Event(1, 2.0, 1.0));
        arrayList.add(new Event(2, 1.0, 3.0));
        arrayList.add(new Event(3, 3.0, 2.0));
        List<Event> list = EventSorter.sort(arrayList);
        for (Event event : list) {
            System.out.println("Priority: " + event.priority + ", Duration: " + event.duration + ", Earliest Time: " + event.earliestTime);
        }
    }
}
