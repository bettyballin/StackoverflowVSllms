import java.lang.String;
import java.lang.Integer;
import java.nio.channels.SelectableChannel;

public class MyTriplet {
    private SelectableChannel channel;
    private ComponentSocketBasis socket;
    private Integer integerValue;

    public MyTriplet(SelectableChannel channel, ComponentSocketBasis socket, Integer integer) {
        this.channel = channel;
        this.socket = socket;
        this.integerValue = integer;
    }

    // getters and setters for your fields here...

    public static void main(String[] args) {
    }
}