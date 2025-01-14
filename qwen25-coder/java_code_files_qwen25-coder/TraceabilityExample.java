// Example to create a simple traceability link between artifacts in Polarion
public class TraceabilityExample {
    public static void main(String[] args) {
        // Assume we have a session already created
        ISession session = createSession();

        // Create link manager instance
        ILinkManager linkManager = session.getService(ILinkManager.class);

        // Fetch work items by their IDs
        IWorkItem requirement = session.getService(IWorkItem.TYPE).loadByUri("workitem:REQ-12345");
        IWorkItem designDocument = session.getService(IWorkItem.TYPE).loadByUri("workitem:DSP-67890");

        // Create a traceability link between the requirement and the design document
        try {
            linkManager.link(requirement, "traces", designDocument);
        } catch (Exception e) {
            System.err.println("Failed to create trace link: " + e.getMessage());
        }

        session.close();
    }

    private static ISession createSession() {
        // Dummy session creation for compilation purposes
        return new ISession() {
            @Override
            public <T> T getService(Class<T> cls) {
                if (cls == IWorkItem.TYPE) {
                    return (T) new IWorkItemService();
                } else if (cls == ILinkManager.class) {
                    return (T) new ILinkManager() {
                        @Override
                        public void link(IWorkItem source, String role, IWorkItem target) throws Exception {
                            // Dummy implementation
                            System.out.println("Link created between " + source + " and " + target);
                        }
                    };
                }
                return null;
            }

            @Override
            public void close() {
                // Dummy implementation
            }
        };
    }
}

// Interfaces and classes to make the code compile
interface ISession {
    <T> T getService(Class<T> cls);

    void close();
}

interface ILinkManager {
    void link(IWorkItem source, String role, IWorkItem target) throws Exception;
}

class IWorkItem {
    public static final Class<IWorkItemService> TYPE = IWorkItemService.class;

    @Override
    public String toString() {
        return "IWorkItem";
    }
}

class IWorkItemService {
    public IWorkItem loadByUri(String uri) {
        // Dummy implementation
        System.out.println("Loading work item with URI: " + uri);
        return new IWorkItem();
    }
}