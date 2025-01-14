import java.util.List;
import technology.tabula.ObjectExtractor;
import technology.tabula.extractors.ExtractionAlgorithm;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
import java.io.File;

public class ExtractTableFromPDF {
    public static void main(String[] args) throws Exception {
        File file = new File("input.pdf");
        ObjectExtractor extractor = new ObjectExtractor(file);

        try (java.io.FileWriter writer = new java.io.FileWriter("output.csv")) {
            ExtractionAlgorithm tableExtractor = SpreadsheetExtractionAlgorithm.INSTANCE;
            for (technology.tabula.Page page : extractor.extract()) {
                java.util.List<technology.tabula.Table> tables = tableExtractor.extract(page);
                for (technology.tabula.Table table : tables) {
                    for (technology.tabula.Row row : table.getRows()) {
                        StringBuilder sb = new StringBuilder();
                        for (technology.tabula.TextChunk cell : row.getTextChunks()) {
                            sb.append(cell.getText()).append(",");
                        }
                        writer.write(sb.toString().trim() + "\n");
                    }
                }
            }
        } finally {
            extractor.close();
        }
    }
}