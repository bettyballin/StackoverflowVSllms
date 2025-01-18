import java.lang.String;
public class DebugModeActivator {

static {
    try {
        throw new TurnOnDebuggerException();
    } catch (TurnOnDebugger td) {
        //Nothing
    }
}

    public static void main(String[] args) {
    }
}

class TurnOnDebugger extends Exception {}

class TurnOnDebuggerException extends TurnOnDebugger {}