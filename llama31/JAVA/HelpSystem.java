import javax.help.HelpBroker;
import javax.help.HelpSet;

public class HelpSystem {
    public static void main(String[] args) {
        // Create a HelpSet instance
        HelpSet hs = new HelpSet(null, "help/HelpSet.hs");

        // Create a HelpBroker instance
        HelpBroker hb = hs.createHelpBroker();

        // Display the help system
        hb.displayHelp();
    }
}