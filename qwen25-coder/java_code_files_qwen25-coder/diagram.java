import java.lang.String;
import org.sparx.*;

public class diagram {
    public static void main(String[] args) {
        // Example API call to create a new class diagram in Enterprise Architect via Automation Interface (script example)
        Repository repository = new Repository();
        repository.OpenFile("C:\\Path\\To\\YourProject.eap");
    
        Package package_ = repository.GetPackageByGuid("{GUID_OF_YOUR_PACKAGE}");
        Diagram diagram = package_.Diagrams.AddNew("Example Diagram", "ClassDiagram");
        diagram.InsertIntoDiagram(repository.GetElementByPath("\\Model\\MyClass"), 0, 0, 2);
        diagram.Update();
    
        repository.RefreshModelView(0);
    }
}