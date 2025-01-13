/*
 * Decompiled with CFR 0.152.
 */
public class MurmurHashCalculator {
    public int hash(int n) {
        int n2 = -862048943;
        int n3 = 461845907;
        int n4 = 15;
        int n5 = 13;
        int n6 = 5;
        int n7 = -430675100;
        int n8 = n;
        n8 ^= n8 >>> n4;
        n8 *= n2;
        n8 ^= n8 >>> n5;
        int n9 = n7;
        n9 ^= n9 >>> 16;
        n9 *= n6;
        n9 ^= n9 >>> 10;
        return n9 ^ (n8 *= n3);
    }

    public static void main(String[] stringArray) {
        MurmurHashCalculator murmurHashCalculator = new MurmurHashCalculator();
        int n = 12345;
        int n2 = murmurHashCalculator.hash(n);
        System.out.println("Hashed key: " + n2);
    }
}
