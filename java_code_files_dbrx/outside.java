import java.util.List;
import java.util.ArrayList;

public class outside {

List<A> list = new ArrayList<>();
String[] test = {"ram", "mohen", "anil", "mukesh", "mittal"};
A objectOfClassA = null; // Create an instance of A class outside the loop so that memory will be reused. It also avoids creating unnecessary temporary objects inside a loop iteration.

{
    for (int i = 0; i < test.length ; i++){
       if (objectOfClassA==null){     // Checking is null, when first object got created for the class A
         objectOfClassA = new A();
       } else {    // If object already instantiated then update fields value and add to list again instead of creating new Object.
          objectOfClassA.setName(test[i]);
       }
      list.add(objectOfClassA);
    }
}

	public static void main(String[] args) {
	}
}

class A {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}