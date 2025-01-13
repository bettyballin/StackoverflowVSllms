import java.util.Set;
import java.util.EnumSet;

// Define the enum
public enum WicketType {
    // enum values
    TYPE1, TYPE2, TYPE3;

    public static void main(String[] args) {
        // Create an instance of Wicket
        Wicket wicket = new Wicket();
        wicket.setId(1);
        wicket.setTypes(EnumSet.of(TYPE1, TYPE2));

        // Print the values
        System.out.println(wicket.getId());
        System.out.println(wicket.getTypes());
    }
}

// Define the Wicket class
class Wicket {
    private Integer id;
    private Set<WicketType> types;

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<WicketType> getTypes() {
        return types;
    }

    public void setTypes(Set<WicketType> types) {
        this.types = types;
    }
}