import java.lang.String;
public class ApplicationTypeSelector {
    public String decideApplicationType(boolean requiresHighPerformance, boolean isPlatformIndependent) {
        if (requiresHighPerformance && !isPlatformIndependent) {
            return "RCP";
        } else if (!requiresHighPerformance && isPlatformIndependent) {
            return "RIA";
        } else {
            return "Consider both based on additional factors like deployment strategy and user base.";
        }
    }

    public static void main(String[] args) {
        ApplicationTypeSelector selector = new ApplicationTypeSelector();
        System.out.println(selector.decideApplicationType(true, false));  // Output: RCP
        System.out.println(selector.decideApplicationType(false, true)); // Output: RIA
    }
}