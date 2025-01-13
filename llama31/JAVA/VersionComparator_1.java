import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VersionComparator_1_1 {
    public static void main(String[] args) {
        List<String> versions = Arrays.asList("1.2.9.1", "1.2.10.5");
        Collections.sort(versions, new VersionComparator());
        System.out.println(versions);
    }
}

class VersionComparator implements java.util.Comparator<String> {
    @Override
    public int compare(String v1, String v2) {
        String[] v1Parts = v1.split("\\.");
        String[] v2Parts = v2.split("\\.");

        int length = Math.max(v1Parts.length, v2Parts.length);
        for (int i = 0; i < length; i++) {
            int v1Part = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int v2Part = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;

            if (v1Part < v2Part) {
                return -1;
            } else if (v1Part > v2Part) {
                return 1;
            }
        }

        return 0;
    }
}