import java.util.List;
import java.util.Arrays;

public class XpathGenerator {

    public static String generateXpath(List<String> reportNames) {
        StringBuilder xpath = new StringBuilder("//Root[");

        for (int i = 0; i < reportNames.size(); i++) {
            if (i > 0) {
                xpath.append(" and ");
            }
            xpath.append(String.format("Policy[Report/Name/text()='%s']", reportNames.get(i)));
        }

        xpath.append("]");
        return xpath.toString();
    }

    public static void main(String[] args) {
        List<String> reports = Arrays.asList("report #1", "report #2");
        String xpathExpression = generateXpath(reports);
        System.out.println(xpathExpression);
    }
}