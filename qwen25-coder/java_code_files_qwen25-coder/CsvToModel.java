import java.io.File;
import java.util.List;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvToModel {

    public <T> List<T> read(String filePath, Class<T> type) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        File file = new File(filePath);
        CsvSchema bootstrapSchema = csvMapper.schemaFor(type).withUseHeader(true);
        List<T> objects = csvMapper.readerWithTypedSchemaFor(type)
             .with(bootstrapSchema)
             .readValues(file)
             .readAll();
        return objects;
    }

    public static void main(String[] args) {
    }
}