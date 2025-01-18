// Example code to handle reputations based on known max levels:

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Root {
    String name();
    boolean strict() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Attribute {
    String name() default "";
    boolean required() default true;
}

@Root(name = "faction", strict = false)
class Faction {
    @Attribute private String name; // Not necessary, but might be useful in your context
    @Attribute(required=false) private int id;  // Not necessary or even present in some cases
    @Attribute private int reputation;

    public Faction(String name, int reputation) {
        this.name = name;
        this.reputation = reputation;
    }

    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation;
    }
}

class Schema {
    // Empty class to allow compilation
}

class SerializableXmlSerializer {
    public SerializableXmlSerializer(Schema schema) {
        // Constructor
    }

    public Object deserialize(InputStream is, Class<?> clazz) {
        // Dummy implementation
        // For demonstration, we can return a list of Factions
        List<Faction> factions = new ArrayList<Faction>();
        factions.add(new Faction("Darnassus", 5000));
        factions.add(new Faction("Stormwind", 15000));
        return factions;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SerializableXmlSerializer xml = new SerializableXmlSerializer(new Schema());
        InputStream is = null; // Not used in dummy implementation
        List<Faction> factions = (List<Faction>) xml.deserialize(is, List.class);

        for (Faction f : factions) {
            int maxReputation; // You should get this value according to specific faction type
            // E.g., if it's a non-favorite faction, set its maximum reputation level:
            if ("Darnassus".equals(f.getName())) { // or compare by id if it exists and reliable
                maxReputation = 9800; // Example value for factions with usual rep cap
            } else { // assuming it's a favorite faction
                maxReputation = 21000; // E.g., exalted rep level for certain other factions
                // Check specific values for your context
            }
            float progress = (float) f.getReputation() / maxReputation * 100f;

            System.out.println("Faction: " + f.getName());
            System.out.println("Current reputation: " + f.getReputation());
            System.out.println("Maximum reputation: " + maxReputation);
            System.out.println("Progress towards exalted standing (based on reputations): " + progress);
        }
    }
}