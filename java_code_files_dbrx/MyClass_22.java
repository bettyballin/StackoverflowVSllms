import java.lang.String;
public class MyClass_22 {
  private int instanceVar = 0;

  public synchronized void setInstanceVar() {
    this.instanceVar++;
  }

  public synchronized int getInstanceVar() {
      return this.instanceVar;
  }

	public static void main(String[] args) {
	}
}