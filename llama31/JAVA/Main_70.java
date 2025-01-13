import com.steadystate.css.parser.CSSOMParser;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

public class Main_70 {
    public static void main(String[] args) throws Exception {
        // Load the CSS file
        InputSource source = new InputSource("path/to/your/css/file.css");

        // Create a new CSS parser
        CSSOMParser parser = new CSSOMParser();

        // Parse the CSS file
        CSSStyleSheet stylesheet = parser.parseStyleSheet(source, null, null);

        // Get the first rule (assuming it's the one you want)
        CSSStyleRule rule = (CSSStyleRule) stylesheet.getCssRules().item(0);

        // Get the value of the property you're interested in
        String propertyValue = rule.getStyle().getPropertyValue("your-property-name");

        // Print the property value
        System.out.println(propertyValue);
    }
}