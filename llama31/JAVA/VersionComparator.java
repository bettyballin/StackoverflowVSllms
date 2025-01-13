import java.util.Comparator;

public class VersionComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] v1 = s1.split("\\.");
        String[] v2 = s2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxLength; i++) {
            int v1Part = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int v2Part = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (v1Part < v2Part) {
                return -1;
            } else if (v1Part > v2Part) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        VersionComparator comparator = new VersionComparator();
        System.out.println(comparator.compare("1.2.3", "1.2.4"));  // Output: -1
        System.out.println(comparator.compare("1.2.3", "1.2.2"));  // Output: 1
        System.out.println(comparator.compare("1.2.3", "1.2.3"));  // Output: 0
    }
}