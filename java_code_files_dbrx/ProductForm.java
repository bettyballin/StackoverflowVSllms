import java.lang.String;
public class ProductForm extends org.apache.struts.action.ActionForm {
  private int id;
  private String productName;
  // setters and getters

  public void setId(int id) {
      this.id = id;
  }
  
  public int getId() {
      return id;
  }
  
  public void setProductName(String productName) {
      this.productName = productName;
  }
  
  public String getProductName() {
      return productName;
  }

	public static void main(String[] args) {
	}
}