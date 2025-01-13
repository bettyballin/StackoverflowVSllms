import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// Define your JavaBean
public class User_25 {
    private String name;
    private String email;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // Read the CSV file
        File file = new File("users.csv");
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            // Map rows to JavaBeans
            List<User> users = new CsvToBeanBuilder<User>(reader)
                .withType(User.class)
                .build()
                .parse();

            // Print the users (optional)
            for (User user : users) {
                System.out.println(user.getName() + ", " + user.getEmail());
            }
        }
    }
}