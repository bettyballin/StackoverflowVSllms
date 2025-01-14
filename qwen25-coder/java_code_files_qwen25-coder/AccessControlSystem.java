import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class AccessControlSystem {
    private Map<String, Policy> policies; // Maps policy IDs to policy objects

    public AccessControlSystem() {
        policies = new HashMap<>();
    }

    public void definePolicy(String policyId, Policy policy) {
        policies.put(policyId, policy);
    }

    public boolean canAccess(User user, Resource object) {
        for (Policy policy : policies.values()) {
            if (policy.appliesTo(user)) {
                return policy.evaluate(user, object); // Evaluate based on user and object attributes
            }
        }
        return false; // Default deny access
    }

    public static void main(String[] args) {
        // Sample usage
        AccessControlSystem acs = new AccessControlSystem();
        
        // Create a policy
        BranchAccessPolicy policy = new BranchAccessPolicy("branch-123");
        acs.definePolicy("policy-1", policy);
        
        // Create a user
        User user = new User();
        user.setAttribute("branch", "branch-123");
        
        // Create a resource
        Resource resource = new Resource();
        resource.setAttribute("branch", "branch-123");
        
        // Check access
        boolean accessGranted = acs.canAccess(user, resource);
        System.out.println("Access granted: " + accessGranted);
    }
}

interface Policy {
    boolean appliesTo(User user);
    boolean evaluate(User user, Resource object);
}

// Example policy implementation
class BranchAccessPolicy implements Policy {
    private String branchId;

    public BranchAccessPolicy(String branchId) {
        this.branchId = branchId;
    }

    @Override
    public boolean appliesTo(User user) {
        return user.hasAttribute("branch", branchId); 
    }

    @Override
    public boolean evaluate(User user, Resource object) {
        return branchId.equals(object.getAttribute("branch"));
    }
}

class User {
    private Map<String, String> attributes;

    public User() {
        attributes = new HashMap<>();
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public boolean hasAttribute(String key, String value) {
        return value.equals(attributes.get(key));
    }
}

class Resource {
    private Map<String, String> attributes;

    public Resource() {
        attributes = new HashMap<>();
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }
}