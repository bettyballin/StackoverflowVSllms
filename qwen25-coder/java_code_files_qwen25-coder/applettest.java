import java.lang.String;
import java.awt.*;
import java.applet.*;

public class applettest extends Applet implements Runnable {

    long lastFrame;

    public void init() { 
        (new Thread(this)).start();
    }

    public void paint(Graphics g) {
        g.drawString("Welcome to Java!!", 50, 60 ); 
    }

    public void run() { 
        while(true) {
            // code here
            repaint();

            try{
                // Calculate the time difference and sleep for the remaining duration
                long now = System.nanoTime();
                long sleepTime = (lastFrame + 16_000_000 - now) / 1_000_000;

                if(sleepTime > 0){
                    Thread.sleep(sleepTime);
                } else {
                    // If we're behind schedule, skip the frame
                    repaint();
                }

                lastFrame = System.nanoTime();
            }
            
            catch(InterruptedException e){}
        }
    }

	public static void main(String[] args) {
	}
}