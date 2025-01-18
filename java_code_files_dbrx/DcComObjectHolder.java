import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// assuming you have created MyDccomFactory class which creates instances of your dccom objects.

public class DcComObjectHolder {
  private static final ApplicationContext context = new AnnotationConfigApplicationContext(MyDccomFactory.class);
  private static Object o; // or whatever is the type of our COM object.
  public static void createObject() {
    if (o == null) { // not strictly necessary, but keeps code cleaner by preventing recreation
        o = context.getBean(MyDccomFactory.class).create(); // or however you instantiate your DCCOM objects.
      }
  }

	public static void main(String[] args) {
	}
}