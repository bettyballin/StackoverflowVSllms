public class CustomActionBarAdvisor extends ActionBarAdvisor {

    private IWorkbenchWindow window;

    public CustomActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
        this.window = configurer.getWindow();
    }

    @Override
    protected void fillMenuBar(IMenuManager menuBar) {
        MenuManager undoRedoGroup = new MenuManager("Edit");
        menuBar.add(undoRedoGroup);

        // Add actions without icons
        undoRedoGroup.add(new Action("Undo") {
            @Override
            public void run() {
                window.getActivePage().getActiveEditor().getActionRegistry()
                        .getAction(ActionFactory.UNDO.getId()).run();
            }

            @Override
            public ImageDescriptor getImageDescriptor() {
                return null; // No icon for this action
            }
        });

        undoRedoGroup.add(new Action("Redo") {
            @Override
            public void run() {
                window.getActivePage().getActiveEditor().getActionRegistry()
                        .getAction(ActionFactory.REDO.getId()).run();
            }

            @Override
            public ImageDescriptor getImageDescriptor() {
                return null; // No icon for this action
            }
        });

        // Repeat similar logic for Cut, Copy, Paste, etc.
    }

    public static void main(String[] args) {
    }
}

// Required supporting classes and interfaces to make the code executable

class ActionBarAdvisor {
    public ActionBarAdvisor(IActionBarConfigurer configurer) {
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    }
}

interface IActionBarConfigurer {
    IWorkbenchWindow getWindow();
}

interface IWorkbenchWindow {
    IWorkbenchPage getActivePage();
}

interface IWorkbenchPage {
    IEditorPart getActiveEditor();
}

interface IEditorPart {
    ActionRegistry getActionRegistry();
}

class ActionRegistry {
    public IAction getAction(String id) {
        return new IAction() {
            @Override
            public void run() {
                // Action implementation
            }
        };
    }
}

interface IAction {
    void run();
}

interface IMenuManager {
    void add(IAction action);
    void add(IMenuManager menu);
}

class MenuManager implements IMenuManager {
    public MenuManager(String name) {
    }

    @Override
    public void add(IAction action) {
    }

    @Override
    public void add(IMenuManager menu) {
    }
}

abstract class Action implements IAction {
    public Action(String name) {
    }

    @Override
    public abstract void run();

    public ImageDescriptor getImageDescriptor() {
        return null;
    }
}

class ImageDescriptor {
    // Image descriptor implementation
}

class ActionFactory {
    public static final ActionFactory UNDO = new ActionFactory("undo");
    public static final ActionFactory REDO = new ActionFactory("redo");

    private String id;

    private ActionFactory(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}