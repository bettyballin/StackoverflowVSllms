import java.lang.String;
public class SubstringExtractor {
    public static int findSubstringPosition(String strA, String strB) {
        // Convert both strings to lowercase to make the search case-insensitive
        int index = strB.toLowerCase().indexOf(strA.toLowerCase());
        return index;
    }

    public static void main(String[] args) {
        String strA1 = "ello";
        String strB1 = "Hello_World";
        System.out.println(findSubstringPosition(strA1, strB1)); // Output: 1

        String strA2 = "blah";
        String strB2 = "blha";
        System.out.println(findSubstringPosition(strA2, strB2)); // Output: -1
    }
}