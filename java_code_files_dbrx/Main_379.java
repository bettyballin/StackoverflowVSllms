import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HeaderColumnNameTranslateMappingStrategy<BeanClass> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(BeanClass.class);

        try (Reader reader = Files.newBufferedReader(Paths.get("yourfile.csv"))) {
            CsvToBean<BeanClass> csvToBean = new CsvToBeanBuilder<BeanClass>(reader)
                .withMappingStrategy(strategy)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

            for (BeanClass record : csvToBean) {
                // Process each BeanClass object here
            }
        } catch(IOException e){
            throw new RuntimeException("Unable to process file", e);
        }
    }
}

class BeanClass {
    // Define the properties and methods of BeanClass here
}