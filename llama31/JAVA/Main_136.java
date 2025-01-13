import com.ximpleware.*;

public class Main_136 {
    public static void main(String[] args) {
        try {
            // Initialize VTDGen and set the file
            VTDGen vg = new VTDGen();
            vg.parseFile("yourfile.xml", false);

            // Get the VTDNav object
            VTDNav vn = vg.getNav();

            // Compile the XPath expression
            AutoPilot ap = new AutoPilot(vn);
            ap.selectXPath("your/xpath/expression");

            // Iterate over the results
            while (ap.evalXPath() != -1) {
                // Process the result
                int elementIndex = vn.getCurrentIndex();
                String text = vn.toNormalizedString(elementIndex);
                System.out.println(text);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}