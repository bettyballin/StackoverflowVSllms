import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>(); // assuming this is your ArrayList
        arrayList.add("Id1");
        arrayList.add("Id2");
        // ... add more IDs as needed
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            if (i < arrayList.size() - 1) {
                sb.append(",");
            }
        }
        String commaDelimitedIDList = sb.toString();
        System.out.println(commaDelimitedIDList);  // prints: Id1,Id2
    }
}