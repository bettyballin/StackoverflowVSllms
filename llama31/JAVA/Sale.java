import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

// Model
public class Sale {
    private int id;
    private Date date;
    private double amount;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

// Controller
interface SaleModel {
    void saveSale(Sale sale);
    List<Sale> getSales();
}

public class SaleController {
    private SaleModel saleModel;

    public SaleController(SaleModel saleModel) {
        this.saleModel = saleModel;
    }

    public void saveSale(Sale sale) {
        saleModel.saveSale(sale);
    }

    public List<Sale> getSales() {
        return saleModel.getSales();
    }
}

// View
public class SaleView extends JFrame {
    private SaleController saleController;

    public SaleView(SaleController saleController) {
        this.saleController = saleController;
        // create the GUI components
    }

    public void saveSale() {
        // get the sale data from the GUI components
        Sale sale = new Sale();
        saleController.saveSale(sale);
    }

    public static void main(String[] args) {
        SaleModel saleModel = new SaleModel() {
            @Override
            public void saveSale(Sale sale) {
                System.out.println("Sale saved");
            }

            @Override
            public List<Sale> getSales() {
                return null;
            }
        };
        SaleController saleController = new SaleController(saleModel);
        SaleView saleView = new SaleView(saleController);
        saleView.saveSale();
    }
}