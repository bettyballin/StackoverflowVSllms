import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Main_803 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("timelog.xml");

            NodeList timeCommands = document.getElementsByTagName("timecommand");
            for (int i = 0; i < timeCommands.getLength(); i++) {
                Node timeCommand = timeCommands.item(i);
                if (timeCommand.getNodeType() == Node.ELEMENT_NODE) {
                    Element timeCommandElement = (Element) timeCommand;
                    String cmd = timeCommandElement.getAttribute("cmd");
                    String date = timeCommandElement.getAttribute("date");
                    String time = timeCommandElement.getAttribute("time");
                    String proj = timeCommandElement.getAttribute("proj");
                    // Process the data...
                    System.out.println("cmd: " + cmd + ", date: " + date + ", time: " + time + ", proj: " + proj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}