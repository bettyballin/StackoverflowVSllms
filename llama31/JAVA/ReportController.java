import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/export")
    public void exportReport(@RequestParam String fileName, @RequestParam String query) throws IOException {
        reportService.exportToCsv(fileName, query);
    }

    public static void main(String[] args) {
    }
}