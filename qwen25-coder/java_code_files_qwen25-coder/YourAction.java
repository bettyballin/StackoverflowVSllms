import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class YourAction extends ActionSupport {
    private Parent parent; // Assuming parent has getEntries() returning List<Entry>

    @Override
    public String execute() throws Exception {
        // Sort the entries by date in descending order
        Collections.sort(parent.getEntries(), new Comparator<Entry>() {
            public int compare(Entry e1, Entry e2) {
                return e2.getDate().compareTo(e1.getDate());
            }
        });

        return SUCCESS;
    }

    public Parent getParent() { return parent; }

    public static void main(String[] args) throws Exception {
        YourAction action = new YourAction();
        action.parent = new Parent(); // Initialize parent
        action.execute();

        // Print the sorted entries
        for (Entry entry : action.parent.getEntries()) {
            System.out.println(entry.getDate());
        }
    }
}

// Define the ActionSupport class
class ActionSupport {
    public static final String SUCCESS = "success";
}

// Define the Parent class
class Parent {
    private List<Entry> entries;

    public Parent() {
        entries = new ArrayList<Entry>();
        // Add some sample entries
        entries.add(new Entry(new Date(1638295200000L))); // 1 Dec 2021
        entries.add(new Entry(new Date(1635703200000L))); // 1 Nov 2021
        entries.add(new Entry(new Date(1633024800000L))); // 1 Oct 2021
    }

    public List<Entry> getEntries() {
        return entries;
    }
}

// Define the Entry class
class Entry {
    private Date date;

    public Entry(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}