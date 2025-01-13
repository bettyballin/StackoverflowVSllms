/*
 * Decompiled with CFR 0.152.
 */
public class CryptoService {
    private final KeyManager keyManager;

    public CryptoService(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public String encrypt(String string) {
        return "Encrypted data";
    }

    public String decrypt(String string) {
        return "Decrypted data";
    }

    public static void main(String[] stringArray) {
        KeyManager keyManager = new KeyManager();
        CryptoService cryptoService = new CryptoService(keyManager);
        String string = cryptoService.encrypt("Hello, World!");
        String string2 = cryptoService.decrypt(string);
        System.out.println("Encrypted data: " + string);
        System.out.println("Decrypted data: " + string2);
    }
}
