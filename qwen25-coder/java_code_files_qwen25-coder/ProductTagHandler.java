import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ProductTagHandler extends TagSupport {
    private String productId;

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public int doStartTag() throws JspException {
        Product product = ProductService.getProductById(productId);
        try {
            pageContext.getOut().write(product.toString());
        } catch (IOException e) {
            throw new JspException("Error: IOException while writing to client " + e.getMessage());
        }
        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}