import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_696_696 {
    public static void main(String[] args) {
        String input = "<DIV id=c445c9c2-a02e-4cec-b254-c134adfa4192 style=\"BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid; BACKGROUND-COLOR: #eeeeee\">\n" +
                "<SPAN id=b8db8cd1-f600-448f-be26-2aa56ea09a9c>\n" +
                "<SPAN id=304ccd38-8161-4def-a557-1a048c963df4>\n" +
                "<IMG src=\"http://avis.co.uk/Assets/build/menu.gif\">\n" +
                "</SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=bc88c866-5370-4c72-990b-06fbe22038d5>\n" +
                "<SPAN id=55b88bbe-15ca-49c9-ad96-cecc6ca7004e>UK<BR></SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=52bb62ca-8f0a-42f1-a13b-9b263225ff1d>\n" +
                "<SPAN id=0e1c3eb6-046d-4f07-96c1-d1ac099d5f1c>\n" +
                "<IMG src=\"http://avis.co.uk/Assets/build/menu.gif\">\n" +
                "</SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=4c29eef2-cd77-4d33-9828-e442685a25cb>\n" +
                "<SPAN id=0d5a266a-14ae-4a89-9263-9e0ab57f7ad2>Italy</SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=f0a72eea-fddd-471e-89e6-56e9b9efbece>\n" +
                "<SPAN id=b7d9ada7-ade0-49fe-aa5f-270237e87c2b>\n" +
                "<IMG src=\"http://avis.co.uk/Assets/build/menu.gif\">\n" +
                "</SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=7604df94-34ba-4c89-bf11-125df01731ff>\n" +
                "<SPAN id=330d6429-4f1b-46a2-a485-9001e2c6b8c1>Netherlands</SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=a18fb516-451e-4c32-ab31-3e3be29235f6>\n" +
                "<SPAN id=6c70238d-78f9-468f-bb8d-370fff13c909>\n" +
                "<IMG src=\"http://avis.co.uk/Assets/build/menu.gif\">\n" +
                "</SPAN>\n" +
                "</SPAN>\n" +
                "<SPAN id=5a2465eb-b337-4f94-a4f8-6f5001dfbd75>\n" +
                "<SPAN id=47877a9e-a7d5-4f13-a41e-6948f899e385>Malta &amp; Gozo\n";

        Pattern pattern = Pattern.compile("<SPAN[^>]*>(.*?)</SPAN>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}