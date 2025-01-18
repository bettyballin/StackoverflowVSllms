import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Service {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Async {}

@Service
public class MyService_1 {
  @Async // This method will be executed asynchronously
  public void doWork() throws InterruptedException {
    Thread.sleep(5000); // Your lengthy process here
    System.out.println("Done!");
  }

  public static void main(String[] args) {
  }
}