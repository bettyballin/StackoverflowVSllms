import java.lang.String;

// Define the ActionForm class
class ActionForm {
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        // Empty method
    }
}

// Define the ActionMapping class
class ActionMapping {
    // Empty class
}

// Define the HttpServletRequest interface
interface HttpServletRequest {
    // Empty interface
}

// Define the Thing class
class Thing {
    // Empty class
}

public class MyForm_1 extends ActionForm {
    private String name;
    private int id;
    private Thing thing;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Thing getThing() {
        if (thing == null) { // Ensure POJO is instantiated
            thing = new Thing();
        }
        return thing;
    }
    
    public void setThing(Thing thing) { this.thing = thing; }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        // Reset or instantiate POJO fields if necessary
        this.setName(null);
        this.setId(0);
        this.setThing(new Thing());
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}