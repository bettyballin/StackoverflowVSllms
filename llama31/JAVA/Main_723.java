import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main_723 {
    public static void main(String[] args) {
        // Assuming daoTemplate is an instance of a class with a query method
        // that returns a list of MyObject instances
        // For the sake of this example, we'll create a list manually
        List<MyObject> theList = new ArrayList<>();
        MyObject obj1 = new MyObject();
        obj1.setDate(new Date(10000)); // arbitrary date
        theList.add(obj1);
        MyObject obj2 = new MyObject();
        obj2.setDate(new Date(20000)); // arbitrary date
        theList.add(obj2);

        MyObject earliest = theList.get(0);
        MyObject latest = theList.get(theList.size() - 1);

        // assuming MyObject has a getDate() method that returns a Date object
        if (earliest.getDate().after(latest.getDate())) {
            // handle incorrect ordering
            System.out.println("Incorrect ordering");
        }
    }
}

class MyObject {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}