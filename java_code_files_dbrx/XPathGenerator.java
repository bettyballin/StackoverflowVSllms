import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;

public class XPathGenerator {
    public static void main(String[] args) throws JsonParserException {
        // Assume a structure of policies each having different report names and you need to get the intersection of reports based on input
        // Let's say user provides "report #1", "report #2" as arguments. The following JSON describes this scenario with made up data:
        String json = "{ \"policies\": [ { \"policyName\": \"p1\", \"reports\": [\"report 1#\", \"report 2#\"] }, { \"policyName\": \"p2\", \"reports\": [\"report #3\" ] } ] }";

        // Parse the JSON string using NanoJSON
        JsonObject jsonObj = JsonParser.object().from(json);
        JsonArray policyArr = jsonObj.getArray("policies");

        String expr = "";
        for (int i = 0; i < policyArr.size(); ++i) { // Loop over all policies provided
            JsonObject policy = policyArr.getObject(i);
            JsonArray reports = policy.getArray("reports");
            String reportNm1 = reports.getString(0);
            String equalsExpression = "(//Policy[" + (i + 1) + "]/Report/Name = '" + reportNm1 + "')"; // For this report we use the first one; in a real case, it can be modified based on input size obviously.
            if (expr.isEmpty())
                expr = equalsExpression;
            else
                expr = expr + " and " + equalsExpression;
        }
        String xpathExpStr = "//Root[" + expr + "]"; // Here is where you've constructed your XPath expression dynamically based on input parameters!
        System.out.println("Generated XPath Expression: " + xpathExpStr);
    }
}