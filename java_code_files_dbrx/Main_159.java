import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import com.github.rcaller.graphics.GraphicsDevice;
import com.github.rcaller.graphics.ScreenshotsFactory;
import com.github.rcaller.util.RCallerConsolePrinter;
import java.io.File;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        RCaller caller = new RCaller();
        RCode code = new RCode();
        // You can use this line to execute command-line R scripts as well
        code.setScript(new File("path/to/your/R_script"));
        caller.setRExecutable("/usr/bin/R");
        // You don’t need a file in case of pure R commands like below
        /*
        code.addRCode("x <- c(1:5)");
        code.addRCode("rnorm <- sqrt(-2 * log(runif(10, min=0, max=3))) * cos(2 * pi * runif(10, min=1, max=6));");
        */
        caller.setRCode(code);
        // This line is used to add R_HOME directory as a library which should be called in your script
        System.out.println("Your R Home Path: " + System.getenv("R_HOME"));
        // Here you pass the argument needed by specific R packages
        Properties props = new Properties();
        props.put("java.class.path", "/usr/bin"); // <--- This line should be added to fix "Couldn't load from server" message.
        caller.setRProperties(props); // If you don’t use properties then comment this out
        // You can get results in console. (You won’t see any plots however)
        RCallerConsolePrinter printer = new RCallerConsolePrinter(caller, 5000, false);
        caller.getRCode().generateCallString(); // If you don't call this method you will get a NullPointerException
        // This is necessary for plotting of graphs
        GraphicsDevice screenshot = ScreenshotsFactory.getGraphicsDevice(caller, "rtest");
        caller.runOnly(); // You can use .runAndReturnResult() if your R code includes calculations and you need to get the result in Java
        // For plotting the graphs you should uncomment the below line and comment the previous one out
        // caller.getRCode().addRCode("library('ggplot2')"); // You can add any package using this command
        screenshot.startPlot();
        // If you use only .runAndReturnResult() to generate the plot then you would have to uncomment the below line and comment out lines including RCallerConsolePrinter
        // String fileAddress = "~/Desktop/"; // This is used for saving the generated output
        // File file = new File(fileAddress);
        caller.getRCode().addRCode("pdf('plot12345.pdf')");
        caller.runOnly();
        printer.close(); // If you use this then remember to close it using this line
    }
}