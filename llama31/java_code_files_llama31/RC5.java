/*
 * Decompiled with CFR 0.152.
 */
public class RC5 {
    private static final int[] P32 = new int[]{-1209970333, 1444465436, -196066091, -1836724886, 1244741753, 1628956097, -1720021710, -1777939129, -1236705581, 1700521155, -1493510619, 1233202760, 438140485, 860378988, -1741878696, -656820684, 2072667742, -1000749726, -641685852, 1094248117, -236340815, -1633853138, 358577064, -1973040660, 1438664586, 1768923740, 1314750409, -1640474785, -2146355078, 1232648289, -734849128, 1350258026};
    private static final int ROUNDS = 12;
    private int[] S = new int[26];

    public RC5(byte[] byArray) {
        int n;
        int n2;
        int n3;
        for (int i = 0; i < this.S.length; ++i) {
            this.S[i] = P32[i % P32.length];
        }
        int[] nArray = new int[(byArray.length + 3) / 4];
        for (n3 = 0; n3 < byArray.length; n3 += 4) {
            n2 = 0;
            for (n = 0; n < 4; ++n) {
                if (n3 + n >= byArray.length) continue;
                n2 |= (byArray[n3 + n] & 0xFF) << 8 * n;
            }
            nArray[n3 / 4] = n2;
        }
        n3 = 0;
        n2 = 0;
        for (n = 0; n < 3 * this.S.length; ++n) {
            this.S[n3] = this.S[n3] + this.S[n2] + (n3 < nArray.length ? nArray[n3] : 0) & 0xFFFFFFFF;
            n3 = (n3 + 1) % this.S.length;
            n2 = (n2 + this.S[n3]) % this.S.length;
        }
    }

    public byte[] encrypt(byte[] byArray) {
        int n;
        int n2;
        int n3;
        int[] nArray = new int[(byArray.length + 3) / 4];
        for (int i = 0; i < byArray.length; i += 4) {
            n3 = 0;
            for (n2 = 0; n2 < 4; ++n2) {
                if (i + n2 >= byArray.length) continue;
                n3 |= (byArray[i + n2] & 0xFF) << 8 * n2;
            }
            nArray[i / 4] = n3;
        }
        int[] nArray2 = new int[nArray.length];
        for (n3 = 0; n3 < nArray.length; n3 += 2) {
            n2 = nArray[n3];
            n = n3 + 1 < nArray.length ? nArray[n3 + 1] : 0;
            n2 = n2 + this.S[0] & 0xFFFFFFFF;
            n = n + this.S[1] & 0xFFFFFFFF;
            for (int i = 1; i <= 12; ++i) {
                n2 ^= n;
                n2 = n2 << (n & 0x1F) | n2 >>> 32 - (n & 0x1F);
                n2 = n2 + this.S[2 * i] & 0xFFFFFFFF;
                n ^= n2;
                n = n << (n2 & 0x1F) | n >>> 32 - (n2 & 0x1F);
                n = n + this.S[2 * i + 1] & 0xFFFFFFFF;
            }
            nArray2[n3] = n2;
            if (n3 + 1 >= nArray2.length) continue;
            nArray2[n3 + 1] = n;
        }
        byte[] byArray2 = new byte[nArray2.length * 4];
        for (n2 = 0; n2 < nArray2.length; ++n2) {
            for (n = 0; n < 4; ++n) {
                byArray2[n2 * 4 + n] = (byte)(nArray2[n2] >>> 8 * n & 0xFF);
            }
        }
        return byArray2;
    }

    public byte[] decrypt(byte[] byArray) {
        int n;
        int n2;
        int n3;
        int[] nArray = new int[(byArray.length + 3) / 4];
        for (int i = 0; i < byArray.length; i += 4) {
            n3 = 0;
            for (n2 = 0; n2 < 4; ++n2) {
                if (i + n2 >= byArray.length) continue;
                n3 |= (byArray[i + n2] & 0xFF) << 8 * n2;
            }
            nArray[i / 4] = n3;
        }
        int[] nArray2 = new int[nArray.length];
        for (n3 = 0; n3 < nArray.length; n3 += 2) {
            n2 = nArray[n3];
            n = n3 + 1 < nArray.length ? nArray[n3 + 1] : 0;
            for (int i = 12; i >= 1; --i) {
                n = n - this.S[2 * i + 1] & 0xFFFFFFFF;
                n = n >>> (n2 & 0x1F) | n << 32 - (n2 & 0x1F);
                n ^= n2;
                n2 = n2 - this.S[2 * i] & 0xFFFFFFFF;
                n2 = n2 >>> (n & 0x1F) | n2 << 32 - (n & 0x1F);
                n2 ^= n;
            }
            n2 = n2 - this.S[0] & 0xFFFFFFFF;
            n = n - this.S[1] & 0xFFFFFFFF;
            nArray2[n3] = n2;
            if (n3 + 1 >= nArray2.length) continue;
            nArray2[n3 + 1] = n;
        }
        byte[] byArray2 = new byte[nArray2.length * 4];
        for (n2 = 0; n2 < nArray2.length; ++n2) {
            for (n = 0; n < 4; ++n) {
                byArray2[n2 * 4 + n] = (byte)(nArray2[n2] >>> 8 * n & 0xFF);
            }
        }
        return byArray2;
    }

    public static void main(String[] stringArray) {
        RC5 rC5 = new RC5("mykey".getBytes());
        byte[] byArray = "Hello, World!".getBytes();
        byte[] byArray2 = rC5.encrypt(byArray);
        byte[] byArray3 = rC5.decrypt(byArray2);
        System.out.println("Plaintext: " + new String(byArray));
        System.out.println("Ciphertext: " + new String(byArray2));
        System.out.println("Decrypted: " + new String(byArray3));
    }
}
