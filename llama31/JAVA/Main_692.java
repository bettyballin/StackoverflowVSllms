import net.datafaker.Faker;

public class Main_692 {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());  // John Doe
        System.out.println(faker.address().streetAddress());  // 123 Main St
    }
}