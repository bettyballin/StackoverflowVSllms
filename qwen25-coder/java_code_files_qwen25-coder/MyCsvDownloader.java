import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class MyCsvDownloader {
    public ResponseEntity<String> downloadCsv() {
        String csvContent = "your,csv,content,here";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv"));
        headers.setContentDispositionFormData("attachment", "export.csv");
        
        return ResponseEntity.ok()
                .headers(headers)
                .body(csvContent);
    }
}