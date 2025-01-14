import java.io.StringReader;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.*;
import com.steadystate.css.parser.CSSOMParser;

public class CSSParserExample {
    public static void main(String[] args) throws Exception {
        String cssContent = "body { background-color: #FFF; font-size: 12px; }";

        // Create a new parser
        InputSource source = new InputSource(new StringReader(cssContent));
        CSSOMParser parser = new CSSOMParser();

        // Parse the CSS content
        CSSStyleSheet sheet = parser.parseStyleSheet(source, null, null);

        // Iterate over all rules in the stylesheet
        CSSRuleList rules = sheet.getCssRules();
        for (int i = 0; i < rules.getLength(); i++) {
            if (rules.item(i) instanceof CSSStyleRule) {
                CSSStyleRule styleRule = (CSSStyleRule) rules.item(i);

                // Get the selector and style declarations
                String selectorText = styleRule.getSelectorText();
                CSSStyleDeclaration styles = styleRule.getStyle();

                // Print each CSS property-value pair for this rule
                System.out.println("Selector: " + selectorText);

                for (int j = 0; j < styles.getLength(); j++) {
                    String propertyName = styles.item(j);
                    String propertyValue = styles.getPropertyValue(propertyName);
                    System.out.println("Property: " + propertyName + "; Value: " + propertyValue);
                }
            }
        }
    }
}