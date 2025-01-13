import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Foo {
    LocalDate start;
    LocalDate end;

    public Foo(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}

public class Main_729_729 {
    public static void main(String[] args) {
        List<Foo> fooList = new ArrayList<>();
        // Example usage
        fooList.add(new Foo(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31)));
        Foo newFoo = new Foo(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28));
        insertAndUpdate(fooList, newFoo);
    }

    public static void insertAndUpdate(List<Foo> list, Foo newFoo) {
        // Ensure list is sorted by start date
        list.sort((a, b) -> a.getStart().compareTo(b.getStart()));

        // Find insertion point and insert
        int index = findInsertionPoint(list, newFoo);
        list.add(index, newFoo);

        // Adjust dates if necessary
        adjustDates(list, index);
    }

    private static int findInsertionPoint(List<Foo> list, Foo newFoo) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStart().isAfter(newFoo.getStart())) {
                return i;
            }
        }
        return list.size();
    }

    private static void adjustDates(List<Foo> list, int index) {
        // Adjust previous if overlaps
        if (index > 0) {
            Foo previous = list.get(index - 1);
            if (previous.getEnd().isAfter(list.get(index).getStart())) {
                previous.setEnd(list.get(index).getStart().minusDays(1));
            }
        }

        // Adjust newFoo if overlaps with next
        if (index < list.size() - 1) {
            Foo next = list.get(index + 1);
            if (list.get(index).getEnd().isAfter(next.getStart())) {
                list.get(index).setEnd(next.getStart().minusDays(1));
            }
        }
    }
}