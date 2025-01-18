import java.lang.String;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
public class Main_363 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; true; i++) {
            // Continually append integers. It will keep consuming memory until crash
            list.add(i);
        }
    }
}