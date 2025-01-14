import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Foo {
    private Date startDate;
    private Date endDate;

    public Foo(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters for startDate and endDate
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
}

public class FooListManager {
    private List<Foo> fooList;

    public FooListManager() {
        fooList = new ArrayList<>();
    }

    public void insertFoo(Foo newFoo) {
        if (fooList.isEmpty()) {
            fooList.add(newFoo);
            return;
        }

        // Sort the list based on start date
        Collections.sort(fooList, (f1, f2) -> f1.getStartDate().compareTo(f2.getStartDate()));

        for (int i = 0; i < fooList.size(); i++) {
            Foo currentFoo = fooList.get(i);

            if (newFoo.getEndDate().before(currentFoo.getStartDate())) {
                // No overlap with rest. Insert the newFoo before the first non-overlapping interval
                fooList.add(i, newFoo);
                return;
            } else if (newFoo.getStartDate().after(currentFoo.getEndDate())) {
                continue;
            }
            // Overlapping intervals found
            Date earliestStart = newFoo.getStartDate().before(currentFoo.getStartDate()) ? newFoo.getStartDate() : currentFoo.getStartDate();
            Date latestEnd = newFoo.getEndDate().after(currentFoo.getEndDate()) ? newFoo.getEndDate() : currentFoo.getEndDate();

            // Adjust the first overlapping interval's start and end date
            currentFoo.setStartDate(earliestStart);
            currentFoo.setEndDate(latestEnd);

            // Merge intervals if necessary with subsequent intervals
            while (i + 1 < fooList.size()) {
                Foo nextFoo = fooList.get(i + 1);
                if (latestEnd.after(nextFoo.getStartDate())) {
                    // Extend the end date of the interval being adjusted and remove the overlapping interval
                    currentFoo.setEndDate(latestEnd.after(nextFoo.getEndDate()) ? latestEnd : nextFoo.getEndDate());
                    fooList.remove(i + 1);
                } else {
                    break;
                }
            }

            return; // NewFoo has been inserted and merged/adjusted in place.
        }

        // If the new Foo's interval ends after all other intervals start, just add it
        fooList.add(newFoo);
    }

    public List<Foo> getFooList() {
        return fooList;
    }

    public static void main(String[] args) {
    }
}