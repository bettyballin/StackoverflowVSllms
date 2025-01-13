/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class AirportNameSuggester {
    private List<String> airportNames;

    public AirportNameSuggester(List<String> list) {
        this.airportNames = list;
    }

    public List<String> suggestAirportNames(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : this.airportNames) {
            int n = this.levenshteinDistance(string, string2);
            if (n > 2) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    private int levenshteinDistance(String string, String string2) {
        int n;
        int[] nArray = new int[string2.length() + 1];
        for (n = 0; n < nArray.length; ++n) {
            nArray[n] = n;
        }
        for (n = 1; n <= string.length(); ++n) {
            nArray[0] = n;
            int n2 = n - 1;
            for (int i = 1; i <= string2.length(); ++i) {
                int n3 = Math.min(1 + Math.min(nArray[i], nArray[i - 1]), string.charAt(n - 1) == string2.charAt(i - 1) ? n2 : n2 + 1);
                n2 = nArray[i];
                nArray[i] = n3;
            }
        }
        return nArray[string2.length()];
    }

    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("New York JFK");
        arrayList.add("Los Angeles LAX");
        arrayList.add("Chicago ORD");
        arrayList.add("Houston IAH");
        arrayList.add("Seattle SEA");
        AirportNameSuggester airportNameSuggester = new AirportNameSuggester(arrayList);
        List<String> list = airportNameSuggester.suggestAirportNames("New");
        System.out.println(list);
    }
}
