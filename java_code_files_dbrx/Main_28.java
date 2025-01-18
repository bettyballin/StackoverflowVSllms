import java.lang.String;
import org.jscience.physics.amount.*;
import org.jscience.physics.model.PhysicalModel;
import org.jscience.physics.model.SI;

public class Main_28 {
    public static void main(String[] args) {
        // Define the physical model to use for units & conversions (SI in this example)
        PhysicalModel model = SI.getInstance();

        Amount mass = model.newAmount("123kg"); 	// Create a new amount of a measure with value and unit
        System.out.println(mass.getValue()); 	// Print the value

        // Convert the existing amount to another unit using unitsOf() method available on the Amount class instance
        mass = mass.to(model.newUnit("pound"));                   // converts to pound (kg -> lb)
    }
}