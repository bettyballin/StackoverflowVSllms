/*
 * Decompiled with CFR 0.152.
 */
public class CalculatorUtils {
    public int add(int n, int n2) {
        return n + n2;
    }

    public void printHello() {
        System.out.println("Hello!");
    }

    public static void main(String[] stringArray) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();
        System.out.println(calculatorUtils.add(2, 3));
        calculatorUtils.printHello();
    }
}
