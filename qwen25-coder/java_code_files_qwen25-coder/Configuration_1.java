import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "configuration")
public class Configuration_1 {

    @XmlElementWrapper(name = "components")
    @XmlElements({
        @XmlElement(name = "serverA", type = ServerA.class),
        @XmlElement(name = "serverB", type = ServerB.class)
    })
    private List<Server> servers;

    @XmlAnyElement
    private List<Object> otherServers;

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public List<Object> getOtherServers() {
        return otherServers;
    }

    public void setOtherServers(List<Object> otherServers) {
        this.otherServers = otherServers;
    }

    public static void main(String[] args) {
    }
}

class Server {
}

class ServerA extends Server {
}

class ServerB extends Server {
}