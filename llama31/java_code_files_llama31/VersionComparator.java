/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class VersionComparator
implements Comparator<String> {
    @Override
    public int compare(String string, String string2) {
        String[] stringArray = string.split("\\.");
        String[] stringArray2 = string2.split("\\.");
        int n = Math.max(stringArray.length, stringArray2.length);
        for (int i = 0; i < n; ++i) {
            int n2;
            int n3 = i < stringArray.length ? Integer.parseInt(stringArray[i]) : 0;
            int n4 = n2 = i < stringArray2.length ? Integer.parseInt(stringArray2[i]) : 0;
            if (n3 < n2) {
                return -1;
            }
            if (n3 <= n2) continue;
            return 1;
        }
        return 0;
    }

    public static void main(String[] stringArray) {
        VersionComparator versionComparator = new VersionComparator();
        System.out.println(versionComparator.compare("1.2.3", "1.2.4"));
        System.out.println(versionComparator.compare("1.2.3", "1.2.2"));
        System.out.println(versionComparator.compare("1.2.3", "1.2.3"));
    }
}
