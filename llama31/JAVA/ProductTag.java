import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.PageContext;

// Placeholder for ProductDao
class ProductDao {
    public static Product findById(Long productId) {
        // This is a placeholder method. Implement your actual logic here.
        return new Product(); // Assuming Product class is also defined somewhere
    }
}

// Placeholder for Product
class Product {
    // Add your product properties and methods here
}

public class ProductTag extends TagSupport {
    private Long productId;
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    @Override
    public int doStartTag() throws JspException {
        Product product = ProductDao.findById(productId);
        pageContext.setAttribute("product", product);
        return EVAL_BODY_INCLUDE;
    }
}