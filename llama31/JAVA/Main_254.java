import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class Main_254_254 {
    public static void main(String[] args) {
        Rengine re = new Rengine();
        re.eval("x <- 1:10");
        REXP result = re.eval("mean(x)");
        System.out.println(result.asDouble());
    }
}