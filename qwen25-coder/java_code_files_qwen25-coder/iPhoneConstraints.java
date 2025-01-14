import java.lang.String;
public class iPhoneConstraints {
    public static void main(String[] args) {
        String[] constraints = {
            "No physical keyboard",
            "No replacable battery",
            "One Application A Time",
            "Sandbox File System",
            "Restricted Deployment Cycle (Dev program...)",
            "App Store Approval Process",
            "Hardware Limitations",
            "Update Cycle",
            "Cost for Development Tools",
            "Location Services Restrictions",
            "Third-party SDK Limitations",
            "Data Storage Size Restrictions",
            "Push Notification Quotas"
        };

        System.out.println("iPhone Platform Constraints:");
        for (String constraint : constraints) {
            System.out.println("- " + constraint);
        }
    }
}