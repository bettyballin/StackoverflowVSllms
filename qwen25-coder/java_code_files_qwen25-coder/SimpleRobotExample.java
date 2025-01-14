import java.lang.String;
// Example of using Java Robot class for basic interactions, not recommended for complex GUIs
   import java.awt.Robot;
   import java.awt.event.InputEvent;

   public class SimpleRobotExample {
       public static void main(String[] args) throws Exception {
           Robot robot = new Robot();
           robot.mouseMove(200, 350);
           robot.delay(1000);
           robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
       }
   }
