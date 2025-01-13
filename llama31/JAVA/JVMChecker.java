import java.lang.String;
public class JVMChecker {
  public static void main(String[] args) {
    System.out.println("JVM: " + System.getProperty("java.vm.info"));
    System.out.println("Java Runtime: " + System.getProperty("java.runtime.version"));
  }
}