import java.util.ArrayList;
import java.util.List;

public class javaStringFormatterThisnameischosenbecausethecodeisusedtoformatacollectionofstringsintoasinglestringwithspecificdelimitersandquotes {
    public static void main(String[] args) {
        String[] strings = {"string1", "string2", "string3"};
        List<String> outputStrings = new ArrayList<>();
        for (String s : strings) {
            outputStrings.add("'" + s + "'");
        }
        String formatted_string = String.join(",", outputStrings);
        System.out.println("(" + formatted_string + ")");
    }
}