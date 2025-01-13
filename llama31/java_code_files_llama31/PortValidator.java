/*
 * Decompiled with CFR 0.152.
 */
public class PortValidator {
    public boolean isValidPort(int n) {
        return n >= 0 && n <= 65535;
    }

    public static void main(String[] stringArray) {
        PortValidator portValidator = new PortValidator();
        System.out.println(portValidator.isValidPort(8080));
        System.out.println(portValidator.isValidPort(-1));
        System.out.println(portValidator.isValidPort(65536));
    }
}
