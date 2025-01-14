import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "MASTER")
public class ScenarioMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ident;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ScenarioSlave> slaves = new HashSet<>();

    // Getters and setters

    public void addSlave(ScenarioSlave slave) {
        slave.setMaster(this);
        this.slaves.add(slave);
    }

    public void removeSlave(ScenarioSlave slave) {
        slave.setMaster(null);
        this.slaves.remove(slave);
    }

    public static void main(String[] args) {
    }
}

class ScenarioSlave {
    private ScenarioMaster master;

    public void setMaster(ScenarioMaster master) {
        this.master = master;
    }
}