import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Configuration {
    @XmlElement
    private List<ServerA> serveras;

    @XmlElement
    private List<ServerB> serverbs;

    @XmlElement
    private List<ServerContribution> contributedServers;

    public static void main(String[] args) {
    }
}

class ServerA {}
class ServerB {}
class ServerContribution {}