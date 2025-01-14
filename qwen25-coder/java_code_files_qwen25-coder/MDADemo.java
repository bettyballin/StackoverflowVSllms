import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

public class MDADemo {
    public static void main(String[] args) {
        EcoreFactory factory = EcoreFactory.eINSTANCE;

        // Create a new package
        EPackage ePackage = factory.createEPackage();
        ePackage.setName("MyModel");
        ePackage.setNsPrefix("mm");
        ePackage.setNsURI("http://www.example.org/mymodel");

        // Create a class in the package
        EClass userClass = factory.createEClass();
        userClass.setName("User");
        ePackage.getEClassifiers().add(userClass);

        System.out.println("Created EPackage with one EClass: " + userClass.getName());
    }
}