import java.lang.String;

public abstract class BaseEngine implements IEngine { // IEngine - hypothetical interface for engine classes

   public BaseEngine(int requiredParameter) {
      init(requiredParameter);
      //...other logic here
    }

    protected void init(int parameter) { // implement in derived classes; must be called with super.init() if overridden in derived class
       // implementation common to all engines here...
       doSomethingUsefulWithParam(parameter);
   }

   private void doSomethingUsefulWithParam(int parameter) {
       // Implementation of the method
   }

   public static void main(String[] args) {
   }
}

interface IEngine {
   // Hypothetical interface methods
}