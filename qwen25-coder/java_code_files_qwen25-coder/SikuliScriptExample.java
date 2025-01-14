import org.sikuli.script.*;

public class SikuliScriptExample {
    // Example SikuliX script snippet
    public static void main(String[] args) throws FindFailed {
        Screen s = new Screen();
        s.click("button.png");
        s.type("input_field.png", "Hello, Siebel!");
    }
}