/*
 * Decompiled with CFR 0.152.
 */
public class PolicyEvaluatorExample {
    public static void main(String[] stringArray) {
        PolicyEngine policyEngine = new PolicyEngine();
        User user = new User("John", "Manager", "Branch A");
        Resource resource = new Resource("Account 123", "Customer Info", "Branch A");
        Policy policy = new Policy("Access To Customer Info", "User.department == 'Branch A' AND User.role == 'Manager'");
        boolean bl = policyEngine.evaluate(user, resource, policy);
        if (bl) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}
