import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListLocalUsers {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "net user");
        pb.redirectErrorStream(true);
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        List<String> localUsers = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("---") || line.trim().length() == 0) {
                continue;
            } else {
                System.out.println(line);
                localUsers.add(line);
            }
        }
    }
}