/*
 * Decompiled with CFR 0.152.
 */
public class PerlinNoiseExample {
    public static void main(String[] stringArray) {
        int n = 6;
        double d = 0.5;
        double d2 = 2.0;
        PerlinNoise perlinNoise = new PerlinNoise(n, d, d2);
        int n2 = 256;
        int n3 = 256;
        double[][] dArray = new double[n2][n3];
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n3; ++j) {
                double d3;
                dArray[i][j] = d3 = perlinNoise.noise((double)i / 10.0, (double)j / 10.0);
            }
        }
    }
}
