public class Main_244 {
    public static void main(String[] args) {
        String input = "a aa[bb b]c cc[d dd]e ee[f ff]";
        String output = input.replaceAll("\\s+(?![^\\[\\]]*\\])", "");
        System.out.println(output); // Output: "aaa[bb b]ccc[d dd]eee[f ff]"
    }
}