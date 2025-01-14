import com.esotericsoftware.yamlbeans.YamlWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class YamlExample {
    public static void main(String[] args) throws Exception {
        ArrayList<HashMap<String, String>> testList = new ArrayList<>();
        HashMap<String, String> testMap1 = new HashMap<>();
        HashMap<String, String> testMap2 = new HashMap<>();

        testMap1.put("1_1", "One");
        testMap1.put("1_3", "Three");
        testMap1.put("1_2", "Two");

        testMap2.put("2_1", "One");
        testMap2.put("2_2", "Two");
        testMap2.put("2_3", "Three");

        testList.add(testMap1);
        testList.add(testMap2);

        StringWriter writer = new StringWriter();
        YamlWriter yamlWriter = new YamlWriter(writer);
        yamlWriter.write(testList);
        yamlWriter.close();

        String jYamlOutput = writer.toString();
        // Remove class tag manually
        String cleanYamlOutput = jYamlOutput.replaceAll("!java\\.util\\.HashMap\\n", "");
        
        System.out.println(cleanYamlOutput);
    }
}