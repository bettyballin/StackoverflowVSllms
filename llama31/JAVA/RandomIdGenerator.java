import java.security.SecureRandom;

public class RandomIdGenerator {
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        long id = sr.nextLong();
        System.out.println(id);
    }
}