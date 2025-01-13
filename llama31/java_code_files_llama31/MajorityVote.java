/*
 * Decompiled with CFR 0.152.
 */
public class MajorityVote {
    public static String majorityVote(String[] stringArray) {
        String string = null;
        int n = 0;
        for (String string2 : stringArray) {
            if (n == 0) {
                string = string2;
                n = 1;
                continue;
            }
            if (string.equals(string2)) {
                ++n;
                continue;
            }
            --n;
        }
        int n2 = 0;
        for (String string3 : stringArray) {
            if (!string3.equals(string)) continue;
            ++n2;
        }
        return n2 > stringArray.length / 2 ? string : null;
    }

    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"A", "A", "A", "C", "C", "B", "B"};
        System.out.println(MajorityVote.majorityVote(stringArray2));
    }
}
