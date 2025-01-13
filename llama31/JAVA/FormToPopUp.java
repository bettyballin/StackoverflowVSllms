import java.io.*;

public class FormToPopUp {
    public static void main(String[] args) {
        String formHTML = "html form html";
        String windowSize = "320x240";  // widthxheight
        String windowTitle = "form popup";
        String windowFeatures = "resizable=0,toolbar=0,location=0,menubar=0,scrollbars=0";  // resizable, toolbar, location, menubar, scrollbars
        String formAction = "action";
        String formTarget = "target";

        String formString = "<HTML>\n"
                + "<HEAD>\n"
                + "<SCRIPT LANGUAGE=\"JavaScript\">\n"
                + "function doSubmit(formName) {\n"
                + "    document.forms[formName].target = \"" + formTarget + "\";\n"
                + "    window.open('about:blank','" + formTarget + "', '" + windowFeatures + "');\n"
                + "    document.forms[formName].submit();\n"
                + "}\n"
                + "</SCRIPT>\n"
                + "</HEAD>\n"
                + "<BODY>\n"
                + "<FORM NAME=\"myForm\" ACTION=\"" + formAction + "\" METHOD=\"POST\" ONSUBMIT=\"doSubmit('myForm'); return false;\">\n"
                + formHTML + "\n"
                + "</FORM>\n"
                + "</BODY>\n"
                + "</HTML>";

        try {
            PrintStream ps = new PrintStream(new FileOutputStream("form.html"));
            ps.println(formString);
            ps.close(); // Close the PrintStream to prevent resource leaks
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}