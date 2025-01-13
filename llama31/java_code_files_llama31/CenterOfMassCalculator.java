/*
 * Decompiled with CFR 0.152.
 */
public class CenterOfMassCalculator {
    public static void calculateCenterOfMass(boolean[][] blArray) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < blArray.length; ++i) {
            for (int j = 0; j < blArray[i].length; ++j) {
                if (!blArray[i][j]) continue;
                n += j;
                n2 += i;
                ++n3;
            }
        }
        if (n3 > 0) {
            double d = (double)n / (double)n3;
            double d2 = (double)n2 / (double)n3;
            System.out.println("Center of Mass: (" + d + ", " + d2 + ")");
        } else {
            System.out.println("No active pixels found.");
        }
    }

    public static void main(String[] stringArray) {
        boolean[][] blArrayArray = new boolean[][]{{true, true, false, false}, {false, true, true, false}, {false, false, true, true}, {false, false, false, true}};
        CenterOfMassCalculator.calculateCenterOfMass(blArrayArray);
    }
}
