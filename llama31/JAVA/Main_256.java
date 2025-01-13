import org.rosuda.REngine.Rserve.RConnection;

public class Main_256_256 {
    public static void main(String[] args) {
        RConnection c = new RConnection();
        c.eval("x <- 1:10");
        double result = c.eval("mean(x)").asDouble();
        System.out.println(result);
        c.close();
    }
}