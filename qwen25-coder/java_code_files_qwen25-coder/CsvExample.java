import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvBindByName;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvExample {
    public static void main(String[] args) throws IOException {
        // Define the CSV file path
        String csv = "path/to/your/csvfile.csv";

        // Create a reader
        try (FileReader reader = new FileReader(csv)) {

            // Convert CSV to JavaBeans
            CsvToBean<MyData> csvToBean = new CsvToBeanBuilder<MyData>(reader)
                    .withType(MyData.class)
                    .build();

            List<MyData> beans = csvToBean.parse();

            // Process the data
            for (MyData bean : beans) {
                System.out.println(bean.toString());
            }
        }
    }

    public static class MyData {  // Example JavaBean

        @CsvBindByName
        private String name;

        @CsvBindByName
        private int age;

        @Override
        public String toString() {
            return "MyData{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}