/*
 * Decompiled with CFR 0.152.
 */
public class AmortizationSchedule {
    public static void main(String[] stringArray) {
        double d = 100000.0;
        double d2 = 0.06;
        int n = 30;
        int n2 = 12;
        double d3 = d2 / 12.0;
        int n3 = n * n2;
        double d4 = AmortizationSchedule.calculateMonthlyPayment(d, d3, n3);
        System.out.println("Monthly Payment: " + d4);
        for (int i = 0; i < n3; ++i) {
            double d5 = d * d3;
            double d6 = d4 - d5;
            d -= d6;
            System.out.println("Payment " + (i + 1) + ": Interest=" + d5 + ", Principal=" + d6);
        }
    }

    public static double calculateMonthlyPayment(double d, double d2, int n) {
        return d * (d2 * Math.pow(1.0 + d2, n)) / (Math.pow(1.0 + d2, n) - 1.0);
    }
}
