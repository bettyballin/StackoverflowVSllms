public class Main_293 {
    public static void main(String[] args) {
        String text = "<a href='https://www.example.com'>Example</a>";
        String cleanText = text.replaceAll("<a.*?>(.*?)</a>", "$1");
        System.out.println(cleanText);
    }
}