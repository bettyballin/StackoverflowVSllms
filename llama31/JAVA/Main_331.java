import java.text.Normalizer;

public class Main_331_331 {
    public static void main(String[] args) {
        String value = "Japón";
        String normalizedValue = Normalizer.normalize(value, Normalizer.NFD);
        String valueWithoutAccents = normalizedValue.replaceAll("[^\\p{ASCII}]", "");
        System.out.println(valueWithoutAccents); // prints "Japon"
    }
}