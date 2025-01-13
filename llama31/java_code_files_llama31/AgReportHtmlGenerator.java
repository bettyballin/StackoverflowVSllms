/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AgReportHtmlGenerator {
    public static void main(String[] stringArray) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("output.html"));
            printWriter.println("<html><head><title>Woohoo</title></head><body><form id='report_form' name='report_form' method='post' action='AgReportServlet'><table border='0' cellspacing='0' cellpadding='8'><tr>   <td><label>Start Date<br />   <select name='start_date' id='start_date'>       <option value='2000'>2000</option>       <option value='2001'>2001</option>       <option value='2002'>2002</option>       <option value='2003'>2003</option>       <option value='2004'>2004</option>   </select> </label></td>   <td>End Date<br />   <select name='end_date' id='end_date'>       <option value='2000'>2000</option>       <option value='2001'>2001</option>       <option value='2002'>2002</option>       <option value='2003'>2003</option>       <option value='2004'>2004</option>   </select></td>   <td><label>Agricultural Zone<br />   <select name='ag_zone' id='ag_zone'>       <option value='1'>Zone 1</option>       <option value='2'>Zone 2</option>       <option value='3'>Zone 3</option>       <option value='4'>Zone 4</option>       <option value='5'>Zone 5</option>   </select> </label></td>   <td><label>Locality<br />   <select name='locality' id='locality'>       <option value='here'>There</option>       <option value='there'>There</option>   </select> </label></td>   <td><label><br />   <input type='submit' name='submit' id='submit' value='Submit' /> </label></td></tr>   </table>   </form></body></html>");
            printWriter.flush();
            printWriter.close();
        }
        catch (IOException iOException) {
            System.out.println("Error writing to file: " + iOException.getMessage());
        }
    }
}
