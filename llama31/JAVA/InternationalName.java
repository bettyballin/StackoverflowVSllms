import java.text.Normalizer;

public class InternationalName {
    private String name;

    public InternationalName(String name) {
        this.name = Normalizer.normalize(name, Normalizer.NFC);
    }

    public String getDisplayString() {
        return name;
    }

    public static void main(String[] args) {
        InternationalName name = new InternationalName("John Dvořák");
        System.out.println(name.getDisplayString());
    }
}