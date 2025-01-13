import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Example {
  private static final String URL = "https://api.example.com/data?token=token123&name=name123";
  private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();

  public static void main(String[] args) throws Exception {
    String csvData = getCsvData();

    List<CSVRecord> csvRecords = parseCsv(csvData);

    List<String> values = getValues(csvRecords);

    csvRecords = modifyCsvRecords(csvRecords);

    String modifiedCsvData = writeCsv(csvRecords);

    setCsvData(modifiedCsvData);
  }

  private static String getCsvData() throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL))
        .GET()
        .build();
    HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
    return response.body();
  }

  private static void setCsvData(String csvData) throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL))
        .header("Content-Type", "text/csv")
        .POST(HttpRequest.BodyPublishers.ofString(csvData, StandardCharsets.UTF_8))
        .build();
    HTTP_CLIENT.send(request, BodyHandlers.ofString());
  }

  private static List<CSVRecord> parseCsv(String csvData) throws Exception {
    return CSVParser.parse(new StringReader(csvData), CSVFormat.DEFAULT).getRecords();
  }

  private static List<String> getValues(List<CSVRecord> csvRecords) {
    return csvRecords.stream()
        .map(record -> record.get(0))
        .collect(Collectors.toList());
  }

  private static List<CSVRecord> modifyCsvRecords(List<CSVRecord> csvRecords) {
    // Modify csvRecords
    return csvRecords;
  }

  private static String writeCsv(List<CSVRecord> csvRecords) throws Exception {
    StringWriter stringWriter = new StringWriter();
    CSVPrinter printer = new CSVPrinter(stringWriter, CSVFormat.DEFAULT);
    printer.printRecords(csvRecords);
    printer.flush();
    return stringWriter.toString();
  }
}