import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyChat extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArrayList<String> myMessages = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) {
                // split the words at the comma ',' into message and name parts
                String[] tokens = line.split("\\,");
                if (tokens.length > 1 && !tokens[0].isEmpty() && !tokens[1].isEmpty()) {
                    myMessages.add(String.format("%s %s", URLEncoder.encode(tokens[0], "UTF-8"), URLEncoder.encode(tokens[1], "UTF-8")));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from input stream.", e);
        }

        response.setContentType("text/html"); // set content type to HTML when sending a response back to the client.
        try (PrintWriter out = response.getWriter()) {
            Iterator<String> it = myMessages.iterator();
            while(it.hasNext()){
                String message = it.next();
                out.println(message);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error writing to output stream.", e);
        }
    }

    public static void main(String[] args) {
    }
}