import java.util.Properties;

public class CommandProcessor {

    Properties props = System.getProperties();

    {
        if(props.containsKey("sun.java.command")){
            String propVal = props.getProperty("sun.java.command");
            // use your logic to process the command line argument value
        }
    }

    public static void main(String[] args) {
    }

}