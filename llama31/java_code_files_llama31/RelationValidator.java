/*
 * Decompiled with CFR 0.152.
 */
public class RelationValidator {
    public boolean isTransitive(boolean[][] blArray) {
        int n;
        int n2;
        int n3 = blArray.length;
        boolean[][] blArray2 = new boolean[n3][n3];
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                blArray2[n2][n] = blArray[n2][n];
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                if (!blArray[n2][n]) continue;
                for (int i = 0; i < n3; ++i) {
                    if (!blArray[n][i]) continue;
                    blArray2[n2][i] = true;
                }
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                if (blArray2[n2][n] == blArray[n2][n]) continue;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] stringArray) {
        RelationValidator relationValidator = new RelationValidator();
        boolean[][] blArrayArray = new boolean[][]{{true, true, false}, {false, true, true}, {false, false, true}};
        System.out.println(relationValidator.isTransitive(blArrayArray));
    }
}
