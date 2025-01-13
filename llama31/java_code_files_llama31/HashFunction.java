/*
 * Decompiled with CFR 0.152.
 */
public class HashFunction {
    public int hash(int n) {
        int n2 = n + -1640531527;
        n2 = (n2 ^ n2 >>> 16) * -2048144789;
        n2 = (n2 ^ n2 >>> 13) * -1028477387;
        return n2 ^ n2 >>> 16;
    }

    public static void main(String[] stringArray) {
        HashFunction hashFunction = new HashFunction();
        System.out.println(hashFunction.hash(12345));
    }
}
