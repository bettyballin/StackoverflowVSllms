import java.util.Date;
import java.io.File;

// User Story: As an employee, I want to quickly submit my expense reports 
//              so that I can be reimbursed without delays.
//
// Acceptance Criteria:
// - The system must allow users to attach receipts via file upload.
// - Each entry should include date, description, and amount.
// - Users can categorize expenses directly through the application.

public class ExpenseReport {
    private Date expenseDate;
    private String description;
    private double amount;
    private ExpenseCategory category;

    // File attachment logic
    public void attachReceipt(File receipt) {
        // Implementation details here
    }

    // Setters and getters omitted for brevity

    public static void main(String[] args) {
    }
}

class ExpenseCategory {
    // Implementation details here
}