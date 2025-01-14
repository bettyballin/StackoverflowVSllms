public class Main {
    public static void main(String[] args) {
        // Constants based on your budget
        int totalBudget = 5000;
        int costPerFastMachine = 2500; // two fast machines at this price
        int costPerMediumMachine = 1200; // four mid-range machines at this price
        int costPerSlowMachine = 600; // eight slower machines at this price

        // Calculate number of nodes for each option within budget
        int numFastMachines = totalBudget / costPerFastMachine;
        int numMediumMachines = totalBudget / costPerMediumMachine;
        int numSlowMachines = totalBudget / costPerSlowMachine;

        System.out.println("Number of Fast Machines: " + numFastMachines); // Expected: 2
        System.out.println("Number of Medium Machines: " + numMediumMachines); // Expected: 4
        System.out.println("Number of Slow Machines: " + numSlowMachines); // Expected: 8
    }
}