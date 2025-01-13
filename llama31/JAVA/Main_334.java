import java.lang.String;
public class Main_334 {
    public static void main(String[] args) {
        String str = "Hello everybody in stackoverflow";
        String[] words = str.split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        System.out.println(reversed.toString().trim());
    }
}