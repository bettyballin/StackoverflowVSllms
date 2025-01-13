import com.github.javafaker.Faker;

public class TestDataGenerator {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String testName = faker.name().fullName();
        String testEmail = faker.internet().emailAddress();
        String testPhone = faker.phoneNumber().phoneNumber();

        System.out.println("Name: " + testName);
        System.out.println("Email: " + testEmail);
        System.out.println("Phone: " + testPhone);
    }
}