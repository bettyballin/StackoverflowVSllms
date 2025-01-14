// ValidationDisabler.java
import org.eclipse.core.resources.IResource;
import org.eclipse.wst.validation.internal.operations.SetUserDefinedAttributesOperation;

// Disable validation for HTML, JSP on a specific resource, e.g., project or file.
public class ValidationDisabler {

    public void disableValidation(IResource resource) {
        SetUserDefinedAttributesOperation operation = new SetUserDefinedAttributesOperation();
        operation.setDisabled(resource);
        try {
            operation.run(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}