import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass_6 {
    
    static class MainClass {
        private int id;
        private List<String> subItems = new ArrayList<>();

        public MainClass(int id) {
            this.id = id;
        }

        public void addSubItem(String item) {
            subItems.add(item);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(id).append("\n");
            for (String subItem : subItems) {
                sb.append("    ").append(subItem).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Simulated data from a database query
        Object[][] rawData = {
                {1, "aaaa"},
                {1, "bbbb"},
                {1, "cccc"},
                {2, "dddd"},
                {3, "eeee"}
        };

        Map<Integer, MainClass> mainClasses = new HashMap<>();

        for (Object[] row : rawData) {
            int id = (Integer) row[0];
            String subItem = (String) row[1];

            mainClasses.putIfAbsent(id, new MainClass(id));
            mainClasses.get(id).addSubItem(subItem);
        }

        for (MainClass mainClass : mainClasses.values()) {
            System.out.print(mainClass);
        }
    }
}