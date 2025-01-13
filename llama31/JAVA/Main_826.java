import java.io.IOException;

public class Main_826 {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("java -Xrunjdwp:transport=dt_socket,server=y,suspend=n -jar your_app.jar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}