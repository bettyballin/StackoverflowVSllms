import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(value = "/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> exportToCsv() throws IOException {
        // Execute Hibernate query here
        String hql = "SELECT u.id, u.name FROM User u"; // Replace with your actual HQL or native SQL
        Query query = entityManager.createNativeQuery(hql);
        List<Object[]> resultList = query.getResultList();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (var writer = new java.io.BufferedWriter(new java.io.OutputStreamWriter(bos))) {

            // Write CSV headers
            writer.write("ID,Name\n");

            // Write data rows
            for (Object[] row : resultList) {
                writer.write(String.format("%s,%s\n", row[0], csvEscape(row[1].toString())));
            }
        }

        byte[] bytes = bos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=report.csv");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(bytes);
    }

    private String csvEscape(String str) {
        if (str == null || (!str.contains(",") && !str.contains("\"")))
            return str;

        // Escape double-quotes by doubling them and wrap the string in double-quotes
        return "\"" + str.replace("\"", "\"\"") + "\"";
    }

    public static void main(String[] args) {
    }
}