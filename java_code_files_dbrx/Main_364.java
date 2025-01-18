import java.lang.String;
public class Main_364 {
    public static void main(String[] args) throws InterruptedException{
        recurse(); // Invoke infinite recursion
    }

    private static void recurse() throws InterruptedException{
       try{Thread.sleep(10);}catch(InterruptedException e){}
       recurse(); // Recursive call, no proper base case or termination condition. This results in a StackOverflowError
   }
}