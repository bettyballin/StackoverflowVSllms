/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class RecordTest {
    static List<Record> records = new ArrayList<Record>();

    public static void testFiltering() {
        Filter filter = new Filter("name", "John");
        List<Record> list = filter.apply(records);
        System.out.println("Test Filtering:");
        System.out.println("Expected size: 1, Actual size: " + list.size());
        System.out.println("Expected name: John, Actual name: " + list.get(0).getName());
    }

    public static void testSorting() {
        SortOrder sortOrder = new SortOrder("name", SortOrder.Direction.ASC);
        List<Record> list = new ArrayList<Record>(records);
        list = sortOrder.apply(list);
        System.out.println("\nTest Sorting:");
        System.out.println("Expected size: 3, Actual size: " + list.size());
        System.out.println("Expected name: Bob, Actual name: " + list.get(0).getName());
        System.out.println("Expected name: Jane, Actual name: " + list.get(1).getName());
        System.out.println("Expected name: John, Actual name: " + list.get(2).getName());
    }

    public static void testPaging() {
        int n = 2;
        int n2 = 0;
        List<Record> list = records.subList(n2 * n, (n2 + 1) * n);
        System.out.println("\nTest Paging:");
        System.out.println("Expected size: 2, Actual size: " + list.size());
        System.out.println("Expected name: John, Actual name: " + list.get(0).getName());
        System.out.println("Expected name: Jane, Actual name: " + list.get(1).getName());
    }

    public static void main(String[] stringArray) {
        RecordTest.testFiltering();
        RecordTest.testSorting();
        RecordTest.testPaging();
    }

    static {
        records.add(new Record(1, "John", "Doe"));
        records.add(new Record(2, "Jane", "Doe"));
        records.add(new Record(3, "Bob", "Smith"));
    }
}
