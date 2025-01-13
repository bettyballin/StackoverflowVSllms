import java.lang.String;
import java.util.Arrays;

public class ExpenseSharing {
    public static void main(String[] args) {
        int[] expenses = {400, 1000, 100};
        int[] settlements = settleExpenses(expenses);
        printSettlements(settlements);
    }

    public static int[] settleExpenses(int[] expenses) {
        int totalExpense = 0;
        for (int expense : expenses) {
            totalExpense += expense;
        }
        int averageExpense = totalExpense / expenses.length;

        int[] debts = new int[expenses.length];
        for (int i = 0; i < expenses.length; i++) {
            debts[i] = expenses[i] - averageExpense;
        }

        Arrays.sort(debts);

        int[] settlements = new int[debts.length];
        int i = 0, j = debts.length - 1;
        while (i < j) {
            int settlement = Math.min(-debts[i], debts[j]);
            settlements[i] = settlement;
            settlements[j] = -settlement;
            debts[i] += settlement;
            debts[j] -= settlement;
            if (debts[i] == 0) {
                i++;
            }
            if (debts[j] == 0) {
                j--;
            }
        }

        return settlements;
    }

    public static void printSettlements(int[] settlements) {
        for (int i = 0; i < settlements.length; i++) {
            if (settlements[i] > 0) {
                System.out.println("Person " + (i + 1) + " pays " + settlements[i] + " to person " + (settlements.length - i));
            }
        }
    }
}