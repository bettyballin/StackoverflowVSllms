import javax.servlet.http.HttpServletResponse;

public class CSVResponseGenerator {

    public static void main(String[] args) {
        // Main method remains empty as per original code
    }

    public void generateResponse(HttpServletResponse response) {
        response.setContentType("text/csv");
        String filename = "desiredFileName" + ".csv"; // Define your desired name and proper extension
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
    }
}