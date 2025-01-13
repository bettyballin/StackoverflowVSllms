// Define the BarcoProjector class
class BarcoProjector {
    public boolean turnOn() {
        // This method will be overridden by the mock object
        return false;
    }
}

public class Main_435 {
    public static void main(String[] args) {
        // Create a mock object for a Barco projector
        BarcoProjector projector = org.mockito.Mockito.mock(BarcoProjector.class);

        // Define the behavior of the mock object
        org.mockito.Mockito.when(projector.turnOn()).thenReturn(true);

        // Use the mock object in your test
        if (projector.turnOn()) {
            System.out.println("Projector turned on");
        }
    }
}