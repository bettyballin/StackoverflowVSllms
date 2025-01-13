/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FormToPopUp {
    public static void main(String[] stringArray) {
        String string = "html form html";
        String string2 = "320x240";
        String string3 = "form popup";
        String string4 = "resizable=0,toolbar=0,location=0,menubar=0,scrollbars=0";
        String string5 = "action";
        String string6 = "target";
        String string7 = "<HTML>\n<HEAD>\n<SCRIPT LANGUAGE=\"JavaScript\">\nfunction doSubmit(formName) {\n    document.forms[formName].target = \"" + string6 + "\";\n    window.open('about:blank','" + string6 + "', '" + string4 + "');\n    document.forms[formName].submit();\n}\n</SCRIPT>\n</HEAD>\n<BODY>\n<FORM NAME=\"myForm\" ACTION=\"" + string5 + "\" METHOD=\"POST\" ONSUBMIT=\"doSubmit('myForm'); return false;\">\n" + string + "\n</FORM>\n</BODY>\n</HTML>";
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("form.html"));
            printStream.println(string7);
            printStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
