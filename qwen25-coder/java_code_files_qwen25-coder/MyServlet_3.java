import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet_3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract data from the form submission
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");

        // Build command to execute .exe with parameters
        ProcessBuilder processBuilder = new ProcessBuilder("path/to/your.exe", param1, param2);

        try {
            // Start the executable
            Process process = processBuilder.start();

            // Read the output from the executable (stdout)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            // Wait for the .exe to exit
            int exitCode = process.waitFor();

            if (exitCode == 0) { // Check if execution was successful
                response.getWriter().println("Result: " + output.toString());
            } else {
                response.getWriter().println("Error executing program.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while processing your request.");
        }
    }

    public static void main(String[] args) {
    }
}