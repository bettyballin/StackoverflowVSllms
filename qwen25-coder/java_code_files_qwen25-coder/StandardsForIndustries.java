import java.util.HashMap;
import java.util.Map;

public class StandardsForIndustries {
    public static void main(String[] args) {
        Map<String, String> industryStandards = new HashMap<>();
        industryStandards.put("Space", "ECSS-E-ST-40C");
        industryStandards.put("Aircraft", "DO-178C");
        industryStandards.put("Banking/Financial", "ISO 23347, PCI DSS");
        industryStandards.put("Automotive", "MISRA C/C++/Ada");
        industryStandards.put("Medical", "IEC 62304");
        industryStandards.put("Defense/Military", "MIL-STD-6815F, EN 50126 & EN 50128");

        for (Map.Entry<String, String> entry : industryStandards.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}