import com.opensymphony.xwork2.ActionSupport;

public class InvoiceAction extends ActionSupport {
    private Invoice invoice;  // This is your Model Class

    public String execute() {
        try {
            saveOrUpdate(invoice);  // Implement the logic to add data into DB
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("Error in execution of the method: " + e);
            return ERROR;
        }
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice inv) {
        this.invoice = inv;
    }

    private void saveOrUpdate(Invoice invoice) {
        // Implement logic to save or update the Invoice object
    }

    public static void main(String[] args) {
        // Entry point of the application
    }
}

class Invoice {
    // Implement the Invoice class details here
}