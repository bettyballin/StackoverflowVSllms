import java.lang.String;
public class OuterLoopControllerorMainLoopercouldbesuitableclassnamesbasedontheprovidedJavacodesnippet {
    static {
        OUTER_LOOP:
        for (;;) {
            // ... lots of code

            if (isEnough()) break OUTER_LOOP;
            // ... more code
        }
    }
    public static void main(String[] args) {
    }

    static boolean isEnough() {
        return false;
    }
}