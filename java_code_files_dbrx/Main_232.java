import java.lang.String;
import javax.script.*; // import the Scripting API
public class Main_232{
  public static void main(String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");
    if (engine != null) {
      System.out.println("Found JavaScript scripting engine.");
      // Execute some JavaScript code from Java
      engine.eval("print('Hello World');");
  } else {
      System.out.println("No JavaScript support found in this JVM.");
    }
  }
}