import java.lang.String;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class WafPlugin {
    public static void build(IProject project) {
        // Get the Waf executable path
        IPath wafPath = project.getLocation().append("waf");

        // Get the build target
        String target = "build";

        // Run Waf with the build target
        try {
            Process process = Runtime.getRuntime().exec(wafPath.toString() + " " + target);
            process.waitFor();
        } catch (Exception e) {
            // Handle errors
        }
    }

	public static void main(String[] args) {
        // To make this code executable, we need an instance of IProject.
        // Since we don't have an Eclipse environment here, we cannot create an instance of IProject directly.
        // For demonstration purposes, the following code is commented out.
        // IProject project = ...; // Initialize project here
        // build(project);
	}
}