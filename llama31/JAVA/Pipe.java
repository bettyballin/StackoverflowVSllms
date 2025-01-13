// Define the NeedInspection interface
interface NeedInspection {
    void inspect();
}

// Original object
public class Pipe {
    public void process() {
        System.out.println("Processing...");
    }
}

// Decorator for Pipe with NeedInspection interface
public class NeedInspectionPipeDecorator extends Pipe implements NeedInspection {
    private Pipe pipe;

    public NeedInspectionPipeDecorator(Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void inspect() {
        System.out.println("Inspecting before processing...");
        pipe.process();
        System.out.println("Inspecting after processing...");
    }

    public static void main(String[] args) {
        Pipe pipe = new Pipe();
        NeedInspectionPipeDecorator decorator = new NeedInspectionPipeDecorator(pipe);
        decorator.inspect();
    }
}