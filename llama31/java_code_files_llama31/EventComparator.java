/*
 * Decompiled with CFR 0.152.
 */
public class EventComparator {
    private static final String SORT_DESCENDING = "DESCENDING";
    private String _sortOrder;

    public EventComparator(String string) {
        this._sortOrder = string;
    }

    public int compare(Event event, Event event2) {
        if (SORT_DESCENDING.equals(this._sortOrder)) {
            int n = Long.compare(event2.getTime(), event.getTime());
            if (n == 0) {
                return Integer.compare(event2.getOriginalIndex(), event.getOriginalIndex());
            }
            return n;
        }
        return Long.compare(event.getTime(), event2.getTime());
    }

    public static void main(String[] stringArray) {
        EventComparator eventComparator = new EventComparator(SORT_DESCENDING);
    }
}
