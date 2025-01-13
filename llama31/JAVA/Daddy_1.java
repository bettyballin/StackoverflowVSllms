import java.lang.String;

public class Daddy_1_1 {
    private static Daddy_1 instance;

    private Daddy_1() {}

    public static Daddy_1 getInstance() {
        if (instance == null) {
            instance = new Daddy_1();
        }
        return instance;
    }

    public void draw() {
        // implementation
    }

    public static void main(String[] args) {
        Daddy_1 daddy = Daddy_1.getInstance();
        daddy.draw();
    }
}