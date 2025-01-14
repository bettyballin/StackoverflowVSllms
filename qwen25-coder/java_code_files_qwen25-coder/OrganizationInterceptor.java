import java.lang.Integer;
import java.lang.String;
import java.io.Serializable;

public class OrganizationInterceptor extends EmptyInterceptor {

    private final HttpSession httpSession; // Assuming you have a way to pass this

    public OrganizationInterceptor(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        setOrganizationId(entity, state, propertyNames);
        return false; // If you don't want to modify the save operation further
    }

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        setOrganizationId(entity, currentState, propertyNames);
        return false; // If you don't want to modify the update operation further
    }

    private void setOrganizationId(Object entity, Object[] state, String[] propertyNames) {
        Integer organizationId = (Integer) httpSession.getAttribute("organizationId");
        if (entity instanceof OrganizationAware) { // Assume this is a marker interface implemented by your entities
            for (int i = 0; i < propertyNames.length; i++) {
                if ("organizationId".equals(propertyNames[i])) {
                    state[i] = organizationId;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}

class EmptyInterceptor {
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        return false;
    }

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        return false;
    }
}

class Type {
}

interface HttpSession {
    public Object getAttribute(String name);
}

interface OrganizationAware {
}