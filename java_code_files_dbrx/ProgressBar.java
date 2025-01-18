import java.lang.String;
public class ProgressBar {
    public static void main(String[] args) throws InterruptedException {
        double percent = 0; //initialize progress at zero

        //simulate process with a loop that updates and prints progress in the console.
        while (percent < 100) {
            Thread.sleep(250); //sleep for some time before updating progress to simulate actual work being done.
            System.out.printf("\rProgress: %3.1f%%", percent += (Math.random() * 10)); //update the percentage
        }
        System.out.println(); //end with a line feed so next print appears on new line
    }
}