import java.lang.String;

public class DerbyEmbeddedDriverLoader {

    static {
        try {
            Class.forName("org.apache.derby.jd*-*bc*.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}