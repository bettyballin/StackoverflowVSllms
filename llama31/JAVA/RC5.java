import java.lang.String;
public class RC5 {
    private static final int[] P32 = {
        0xB7E15163, 0x5618CB1C, 0xF45044D5, 0x9285CD6A,
        0x4A314079, 0x6117E5C1, 0x997A8D32, 0x9606CD47,
        0xB6495ED3, 0x655BE4C3, 0xA6FAD625, 0x49812E48,
        0x1A1D7E45, 0x3348576C, 0x982D0A58, 0xD8D9B634,
        0x7B8A665E, 0xC459C562, 0xD9C0A6A4, 0x4138E6B5,
        0xF1E9B9B1, 0x9E9D612E, 0x155F73A8, 0x8A65C9EC,
        0x55C0478A, 0x696FA25C, 0x4E5D7FC9, 0x9E38575F,
        0x8011387A, 0x4978B861, 0xD4331798, 0x507B4D6A
    };

    private static final int ROUNDS = 12;

    private int[] S;

    public RC5(byte[] key) {
        S = new int[2 * ROUNDS + 2];
        for (int i = 0; i < S.length; i++) {
            S[i] = P32[i % P32.length];
        }

        int[] L = new int[(key.length + 3) / 4];
        for (int i = 0; i < key.length; i += 4) {
            int val = 0;
            for (int j = 0; j < 4; j++) {
                if (i + j < key.length) {
                    val |= (key[i + j] & 0xFF) << (8 * j);
                }
            }
            L[i / 4] = val;
        }

        int i = 0, j = 0;
        for (int k = 0; k < 3 * S.length; k++) {
            S[i] = (S[i] + S[j] + (i < L.length ? L[i] : 0)) & 0xFFFFFFFF;
            i = (i + 1) % S.length;
            j = (j + S[i]) % S.length;
        }
    }

    public byte[] encrypt(byte[] plaintext) {
        int[] input = new int[(plaintext.length + 3) / 4];
        for (int i = 0; i < plaintext.length; i += 4) {
            int val = 0;
            for (int j = 0; j < 4; j++) {
                if (i + j < plaintext.length) {
                    val |= (plaintext[i + j] & 0xFF) << (8 * j);
                }
            }
            input[i / 4] = val;
        }

        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i += 2) {
            int a = input[i];
            int b = i + 1 < input.length ? input[i + 1] : 0;

            a = (a + S[0]) & 0xFFFFFFFF;
            b = (b + S[1]) & 0xFFFFFFFF;

            for (int j = 1; j <= ROUNDS; j++) {
                a ^= b;
                a = (a << (b & 0x1F)) | (a >>> (32 - (b & 0x1F)));
                a = (a + S[2 * j]) & 0xFFFFFFFF;

                b ^= a;
                b = (b << (a & 0x1F)) | (b >>> (32 - (a & 0x1F)));
                b = (b + S[2 * j + 1]) & 0xFFFFFFFF;
            }

            output[i] = a;
            if (i + 1 < output.length) {
                output[i + 1] = b;
            }
        }

        byte[] ciphertext = new byte[output.length * 4];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < 4; j++) {
                ciphertext[i * 4 + j] = (byte) ((output[i] >>> (8 * j)) & 0xFF);
            }
        }

        return ciphertext;
    }

    public byte[] decrypt(byte[] ciphertext) {
        int[] input = new int[(ciphertext.length + 3) / 4];
        for (int i = 0; i < ciphertext.length; i += 4) {
            int val = 0;
            for (int j = 0; j < 4; j++) {
                if (i + j < ciphertext.length) {
                    val |= (ciphertext[i + j] & 0xFF) << (8 * j);
                }
            }
            input[i / 4] = val;
        }

        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i += 2) {
            int a = input[i];
            int b = i + 1 < input.length ? input[i + 1] : 0;

            for (int j = ROUNDS; j >= 1; j--) {
                b = (b - S[2 * j + 1]) & 0xFFFFFFFF;
                b = (b >>> (a & 0x1F)) | (b << (32 - (a & 0x1F)));
                b ^= a;

                a = (a - S[2 * j]) & 0xFFFFFFFF;
                a = (a >>> (b & 0x1F)) | (a << (32 - (b & 0x1F)));
                a ^= b;
            }

            a = (a - S[0]) & 0xFFFFFFFF;
            b = (b - S[1]) & 0xFFFFFFFF;

            output[i] = a;
            if (i + 1 < output.length) {
                output[i + 1] = b;
            }
        }

        byte[] plaintext = new byte[output.length * 4];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < 4; j++) {
                plaintext[i * 4 + j] = (byte) ((output[i] >>> (8 * j)) & 0xFF);
            }
        }

        return plaintext;
    }

    public static void main(String[] args) {
        RC5 rc5 = new RC5("mykey".getBytes());
        byte[] plaintext = "Hello, World!".getBytes();
        byte[] ciphertext = rc5.encrypt(plaintext);
        byte[] decrypted = rc5.decrypt(ciphertext);

        System.out.println("Plaintext: " + new String(plaintext));
        System.out.println("Ciphertext: " + new String(ciphertext));
        System.out.println("Decrypted: " + new String(decrypted));
    }
}