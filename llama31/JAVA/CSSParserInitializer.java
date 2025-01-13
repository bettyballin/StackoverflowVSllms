import java.lang.String;

public class CSSParserInitializer {
    static {
        System.setProperty("org.w3c.css.sac.parser", "org.w3c.css.sac.impl.CSSOMParser");
    }

    public static void main(String[] args) {
    }
}