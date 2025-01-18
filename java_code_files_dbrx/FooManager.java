import java.util.List;

public class FooManager {
    public void addFoo(List<Foo> foos, Foo newFoo) {
        int i = 0;
        // Find the correct position to insert `newFoo`
        while (i < foos.size() && foos.get(i).endDate <= newFoo.startDate) {
            i++;
        }

        // Insert new Foo into position at index and adjust its end date (if necessary)
        foos.add(i, newFoo);
        if (i < foos.size() - 1 && newFoo.endDate > foos.get(i + 1).startDate) {
            newFoo.endDate = foos.get(i + 1).startDate;
        }

        // Adjust end date of the previous Foo (if any) and start dates of following Foos
        if (i > 0) {
            foos.get(i - 1).endDate = newFoo.startDate;
        }
        for (int j = i + 1; j < foos.size(); ++j) {
            if (newFoo.endDate >= foos.get(j).startDate) {
                foos.get(j).startDate = newFoo.endDate;
            } else break; // No need to update further, end dates of following Foos are already beyond `newFoo`s end time
        }
    }

    public static void main(String[] args) {
    }
}

class Foo {
    public int startDate;
    public int endDate;

    public Foo(int startDate, int endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}