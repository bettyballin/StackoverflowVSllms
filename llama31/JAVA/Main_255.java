import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class Main_255_255 {
    public static void main(String[] args) {
        Rengine re = new Rengine(new String[] {"--vanilla"}, false, null);
        re.eval("x <- 1:10");
        REXP result = re.eval("mean(x)");
        System.out.println(result.asDouble());
        re.end();
    }
}