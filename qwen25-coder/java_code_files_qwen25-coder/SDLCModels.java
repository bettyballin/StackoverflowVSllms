public class SDLCModels {
    public static void main(String[] args) {
        System.out.println("Agile Sprint Phases:");
        for (String phase : AgileSprintPhases()) {
            System.out.println(phase);
        }
        
        System.out.println("\nSpiral Model Cycles:");
        for (String cycle : SpiralModelCycles()) {
            System.out.println(cycle);
        }
    }

    public static String[] AgileSprintPhases() {
        return new String[]{"Planning", "Execution", "Review", "Adjustment"};
    }

    public static String[] SpiralModelCycles() {
        return new String[]{"Objective Setting", "Risk Analysis", "Engineering", "Customer Evaluation"};
    }
}