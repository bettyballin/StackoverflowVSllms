import java.io.File;
import java.net.URL;
import javax.help.HelpSet;
import javax.help.JHelp;

public class HelpSystemExample {
    public static void main(String[] args) throws Exception {
        // Load the help set file (HSF)
        URL hsURL = new File("path/to/your/helpset.hs").toURI().toURL();
        HelpSet helpSet = new HelpSet(null, hsURL);

        // Create and display a JHelpViewer window
        JHelp jHelp = new JHelp(helpSet);
        jHelp.setSize(800, 600);
        jHelp.setLocationRelativeTo(null);
        jHelp.setVisible(true);
    }
}