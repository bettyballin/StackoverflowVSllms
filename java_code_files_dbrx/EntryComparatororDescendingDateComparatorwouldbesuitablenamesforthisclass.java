import java.util.*;

public class EntryComparatororDescendingDateComparatorwouldbesuitablenamesforthisclass {
    Parent parent = new Parent();

    public EntryComparatororDescendingDateComparatorwouldbesuitablenamesforthisclass() {
        List<Entry> entries = parent.getEntries();
        Collections.sort(entries, new Comparator<Entry>() {
            @Override
            public int compare(Entry e1, Entry e2) {
                return -e1.getDate().compareTo(e2.getDate());
            }
        });
    }

    public static void main(String[] args) {
        new EntryComparatororDescendingDateComparatorwouldbesuitablenamesforthisclass();
    }
}

class Parent {
    public List<Entry> getEntries() {
        return new ArrayList<Entry>();
    }
}

class Entry {
    public Date getDate() {
        return new Date();
    }
}