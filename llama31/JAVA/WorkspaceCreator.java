import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

public class WorkspaceCreator {
    public static void main(String[] args) {
        // Create a new workspace
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();

        // Create a new project
        IProject project = root.getProject("MyProject");
        try {
            project.create(null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }
}