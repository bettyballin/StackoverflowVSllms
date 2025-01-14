import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;

public class MyExampleModelGenerator {
    // Example: Creating a simple EClass in EMF programmatically

    EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
    EClass eClass = EcoreFactory.eINSTANCE.createEClass();

    {
        ePackage.setName("MyExample");
        ePackage.setNsPrefix("ex");
        ePackage.setNsURI("http://www.example.com/mymodel");

        eClass.setName("SampleClass");
        ePackage.getEClassifiers().add(eClass);
    }

    public static void main(String[] args) {
    }
}