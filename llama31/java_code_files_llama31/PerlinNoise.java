/*
 * Decompiled with CFR 0.152.
 */
class PerlinNoise {
    private int octaves;
    private double persistence;
    private double lacunarity;

    public PerlinNoise(int n, double d, double d2) {
        this.octaves = n;
        this.persistence = d;
        this.lacunarity = d2;
    }

    public double noise(double d, double d2) {
        double d3 = 1.0;
        double d4 = 1.0;
        double d5 = 0.0;
        for (int i = 0; i < this.octaves; ++i) {
            d5 += d3 * this.noiseOctave(d * d4, d2 * d4);
            d3 *= this.persistence;
            d4 *= this.lacunarity;
        }
        return d5;
    }

    private double noiseOctave(double d, double d2) {
        int n = (int)Math.floor(d);
        int n2 = (int)Math.floor(d2);
        int n3 = n + 1;
        int n4 = n2 + 1;
        double d3 = d - (double)n;
        double d4 = d2 - (double)n2;
        double d5 = this.noiseGrad(n, n2, d3, d4);
        double d6 = this.noiseGrad(n3, n2, d3 - 1.0, d4);
        double d7 = this.noiseGrad(n, n4, d3, d4 - 1.0);
        double d8 = this.noiseGrad(n3, n4, d3 - 1.0, d4 - 1.0);
        double d9 = this.interpolate(d5, d6, d3);
        double d10 = this.interpolate(d7, d8, d3);
        return this.interpolate(d9, d10, d4);
    }

    private double noiseGrad(int n, int n2, double d, double d2) {
        int n3 = n * 57 + n2 * 133;
        int n4 = 4;
        int n5 = n3 % n4;
        switch (n5) {
            case 0: {
                return d + d2;
            }
            case 1: {
                return -d + d2;
            }
            case 2: {
                return d - d2;
            }
            case 3: {
                return -d - d2;
            }
        }
        return 0.0;
    }

    private double interpolate(double d, double d2, double d3) {
        double d4 = d3 * 3.1415927;
        double d5 = (double)(1.0f - (float)Math.cos(d4)) * 0.5;
        return d * (1.0 - d5) + d2 * d5;
    }
}
