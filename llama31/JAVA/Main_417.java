import java.net.URI;

public class Main_417 {
    public static void main(String[] args) {
        URI myUri = URI.create("http://someDomain/someFile.dat");
        System.out.println(myUri);
        // or
        myUri = URI.create("file://c:/files/someFile.dat");
        System.out.println(myUri);
        // or
        myUri = URI.create("c:/files/someFile.dat");
        System.out.println(myUri);
    }
}