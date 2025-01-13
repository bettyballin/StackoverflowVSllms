import java.lang.String;
public class AmortizationSchedule {
    public static void main(String[] args) {
        double loanAmount = 100000; // P
        double interestRate = 0.06; // r
        int loanTerm = 30; // n
        int paymentFrequency = 12; // monthly

        double monthlyInterestRate = interestRate / 12;
        int numberOfPayments = loanTerm * paymentFrequency;

        double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, numberOfPayments);

        System.out.println("Monthly Payment: " + monthlyPayment);

        for (int i = 0; i < numberOfPayments; i++) {
            double interest = loanAmount * monthlyInterestRate;
            double principal = monthlyPayment - interest;
            loanAmount -= principal;

            System.out.println("Payment " + (i + 1) + ": Interest=" + interest + ", Principal=" + principal);
        }
    }

    public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfPayments) {
        return loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}