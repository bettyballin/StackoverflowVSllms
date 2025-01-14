import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ManagedBean(name="logViewerBean")
@SessionScoped
public class LogViewerBean {
    private List<String> logEntries;

    public void fetchLogs() throws FileNotFoundException {
        // Define a path to the server.log
        String logFilePath = "[GlassfishFolder]/domains/domain1/logs/server.log";
        
        File file = new File(logFilePath);
        Scanner scanner = new Scanner(file);

        logEntries = new ArrayList<>();
        while (scanner.hasNextLine()) {
            logEntries.add(scanner.nextLine());
        }
        scanner.close();
    }

    public List<String> getLogEntries() {
        return logEntries;
    }

    // Add authentication and authorization checks as needed

    public static void main(String[] args) {
    }
}