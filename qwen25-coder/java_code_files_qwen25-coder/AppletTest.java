public class AppletTest {

    public static void main(String[] args) {
        // Assuming there is a visible applet window named "MyApplet"
        JFrameOperator jfo = new JFrameOperator("MyApplet");
        
        // Find and click a button within the applet
        JButtonOperator buttonOp = new JButtonOperator(jfo, "Click Me");
        buttonOp.clickMouse();
    }
}

class JFrameOperator {

    public JFrameOperator(String title) {
        // Constructor code here
    }
    // Additional methods as needed
}

class JButtonOperator {

    public JButtonOperator(JFrameOperator frameOp, String buttonText) {
        // Constructor code here
    }

    public void clickMouse() {
        // Method code here
    }
}