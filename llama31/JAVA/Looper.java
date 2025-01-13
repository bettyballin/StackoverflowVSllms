import java.lang.String;

public class Looper {
    public static void main(String[] args) {
        new Looper().loop();
    }

    public void loop() {
        OUTER_LOOP: for (int i = 0; i < 10; i++) {
            //...lots of code

            if (isEnough(i)) break OUTER_LOOP;
            //...more code
        }
    }

    public boolean isEnough(int i) {
        return i > 5; // replace with your own logic
    }
}