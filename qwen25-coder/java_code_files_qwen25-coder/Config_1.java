import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "config")
public class Config_1 {
    private String setting1;
    private int setting2;

    // Getters and Setters
    @XmlElement(name = "setting1")
    public String getSetting1() { return setting1; }
    public void setSetting1(String setting1) { this.setting1 = setting1; }

    @XmlElement(name = "setting2")
    public int getSetting2() { return setting2; }
    public void setSetting2(int setting2) { this.setting2 = setting2; }

    public static void main(String[] args) {
    }
}