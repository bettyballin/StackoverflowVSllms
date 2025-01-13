import javax.management.snmp.SnmpAgent;

public class Main_240 {
    public static void main(String[] args) {
        SnmpAgent agent = new SnmpAgent();
        agent.addMibModule(new MyMibModule());
    }
}

class MyMibModule implements javax.management.snmp.SnmpMibModule {
    // Your implementation here
    public void load(javax.management.snmp.SnmpMibModuleRegistration registration) {
        // Your load implementation here
    }

    public void unload() {
        // Your unload implementation here
    }
}