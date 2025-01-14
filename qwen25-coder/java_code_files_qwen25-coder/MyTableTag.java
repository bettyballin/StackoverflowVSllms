import java.lang.String;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspTagException;
import javax.servlet.ServletRequest;
import java.util.Collection;
import java.io.IOException;

public class MyTableTag extends TagSupport {
    private String collectionName;

    public void setCollectionName(String name) {
        this.collectionName = name;
    }

    @Override
    public int doStartTag() throws JspException {
        ServletRequest request = pageContext.getRequest();
        Collection<?> collection = (Collection<?>) request.getAttribute(collectionName);

        if (collection == null) {
            throw new JspException("Attribute '" + collectionName + "' is not provided.");
        }

        JspWriter out = pageContext.getOut();

        // Assuming printTable is a method you use to render your table
        try {
            printTable(out, collection);
        } catch (IOException e) {
            throw new JspTagException("Error outputting data");
        }

        return SKIP_BODY;
    }

    private void printTable(JspWriter out, Collection<?> collection)
                            throws IOException, JspException {

        // Code to iterate the collection and print each item as a row in a table
        out.write("<table>");
        for (Object item : collection) {
            out.write("<tr><td>" + item.toString() + "</td></tr>");
        }
        out.write("</table>");
    }

    public static void main(String[] args) {
    }
}