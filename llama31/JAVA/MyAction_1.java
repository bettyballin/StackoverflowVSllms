import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyAction_1_1 extends ActionSupport {
    private List<MyEntry> entries;

    public String execute() {
        // Retrieve the entries collection
        entries = parent.getEntries();

        // Sort the entries collection by date
        Collections.sort(entries, new Comparator<MyEntry>() {
            public int compare(MyEntry e1, MyEntry e2) {
                return e2.getDate().compareTo(e1.getDate());
            }
        });

        return SUCCESS;
    }

    public List<MyEntry> getEntries() {
        return entries;
    }

    public static void main(String[] args) {
    }
}