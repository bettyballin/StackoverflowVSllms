import java.util.ArrayList;
import java.util.List;

public class Main_283 {
    public static void main(String[] args)  {
        List<Runnable> runners = new ArrayList<>();
        String[] names = {"John", "Doe"};
        int idx;
        for (idx=0; idx < names.length ; idx++){
            final int copyOfIndex = idx;
            runners.add(() -> System.out.println("Hello " + names[copyOfIndex]));
        }
        runners.forEach(runnable -> runnable.run());
    }
}