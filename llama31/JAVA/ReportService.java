import java.lang.String;
import java.lang.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan
@Service
public class ReportService {

    @Autowired
    private SessionFactory sessionFactory;

    public void exportToCsv(String fileName, String query) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        Query queryResult = session.createQuery(query);
        List results = queryResult.getResultList();

        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(',')
                    .withQuotechar('"')
                    .withEscapechar('\\')
                    .withLineEnd("\n")
                    .build();

            beanToCsv.write(results);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ReportService.class);
        ReportService reportService = context.getBean(ReportService.class);
        // You need to configure the sessionFactory bean, you can do this by creating a configuration class
        // reportService.exportToCsv("example.csv", "from ExampleEntity");
    }
}