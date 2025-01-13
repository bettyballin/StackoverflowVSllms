import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.text.StringEscapeUtils;

public class UserInputEncoder {
    public void encodeInput(HttpServletRequest request, JspWriter out) {
        String userInput = request.getParameter("userInput");
        String encodedInput = StringEscapeUtils.escapeHtml4(userInput);
        out.println(encodedInput);
    }

    public static void main(String[] args) {
        // This main method is not being used, but is required for the class to compile
    }
}