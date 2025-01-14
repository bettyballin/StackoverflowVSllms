import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Config {
    private String setting1;
    private int setting2;

    public Config() {
    }

    @XmlElement
    public String getSetting1() {
        return setting1;
    }

    public void setSetting1(String setting1) {
        this.setting1 = setting1;
    }

    @XmlElement
    public int getSetting2() {
        return setting2;
    }

    public void setSetting2(int setting2) {
        this.setting2 = setting2;
    }
}

public class Main_124 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("config.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Config config = (Config) unmarshaller.unmarshal(xmlFile);
            
            System.out.println("Setting1: " + config.getSetting1());
            System.out.println("Setting2: " + config.getSetting2());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}