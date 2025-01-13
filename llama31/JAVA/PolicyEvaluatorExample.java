import java.lang.String;

// Define User class
class User {
    String name;
    String role;
    String department;

    public User(String name, String role, String department) {
        this.name = name;
        this.role = role;
        this.department = department;
    }
}

// Define Resource class
class Resource {
    String name;
    String type;
    String department;

    public Resource(String name, String type, String department) {
        this.name = name;
        this.type = type;
        this.department = department;
    }
}

// Define Policy class
class Policy {
    String name;
    String rule;

    public Policy(String name, String rule) {
        this.name = name;
        this.rule = rule;
    }
}

// Define PolicyEngine class
class PolicyEngine {
    public boolean evaluate(User user, Resource resource, Policy policy) {
        // Simple implementation for demonstration purposes
        String[] conditions = policy.rule.split(" AND ");
        boolean accessGranted = true;

        for (String condition : conditions) {
            String[] parts = condition.split("==");
            String attribute = parts[0].trim();
            String value = parts[1].trim();

            if (attribute.equals("User.department")) {
                if (!user.department.equals(value)) {
                    accessGranted = false;
                    break;
                }
            } else if (attribute.equals("User.role")) {
                if (!user.role.equals(value)) {
                    accessGranted = false;
                    break;
                }
            } else if (attribute.equals("Resource.department")) {
                if (!resource.department.equals(value)) {
                    accessGranted = false;
                    break;
                }
            }
        }

        return accessGranted;
    }
}

public class PolicyEvaluatorExample {
    public static void main(String[] args) {
        // Define attributes for user and resource
        User user = new User("John", "Manager", "Branch A");
        Resource resource = new Resource("Account 123", "Customer Info", "Branch A");

        // Define policy
        Policy policy = new Policy("Access To Customer Info",
            "User.department == 'Branch A' AND User.role == 'Manager'");

        // Create policy engine
        PolicyEngine policyEngine = new PolicyEngine();

        // Evaluate policy
        boolean accessGranted = policyEngine.evaluate(user, resource, policy);

        if (accessGranted) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}