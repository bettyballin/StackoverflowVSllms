import java.util.*;

class Node {
    int id;
    double productionRate; // max can produce per day
    double consumptionRate; // max can consume per day
    double currentProduction; // currently producing
    double currentConsumption; // currently consuming
    double storageCapacity;
    double currentStorageLevel; // how much storage is used
    Set<Node> neighbors;
    double responsibility;

    Node(int id, double productionRate, double consumptionRate,
         double currentProduction, double currentConsumption,
         double storageCapacity, double currentStorageLevel) {
        this.id = id;
        this.productionRate = productionRate;
        this.consumptionRate = consumptionRate;
        this.currentProduction = currentProduction;
        this.currentConsumption = currentConsumption;
        this.storageCapacity = storageCapacity;
        this.currentStorageLevel = currentStorageLevel;
        this.neighbors = new HashSet<>();
        this.responsibility = 0.0;
    }

    void updateResponsibility(double newConsumptionRate) {
        this.responsibility = newConsumptionRate - this.currentProduction + (this.storageCapacity - this.currentStorageLevel);
    }
}

public class FlowController {
    private List<Node> nodes;

    public FlowController(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void adjustConnections() {
        for (Node node : nodes) {
            updateResponsibilities();
            balanceLoad(node);
            optimizeConnections(node);
        }
    }

    private void updateResponsibilities() {
        for (Node node : nodes) {
            node.updateResponsibility(calculateDynamicConsumption(node));
        }
    }

    private double calculateDynamicConsumption(Node node) {
        // Implement logic to predict or measure dynamic consumption
        // Using a placeholder multiplier for now
        return node.consumptionRate * 1.0; // Replace 1.0 with actual multiplier based on historical data
    }

    private void balanceLoad(Node node) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(n -> n.responsibility));
        for (Node neighbor : node.neighbors) {
            priorityQueue.offer(neighbor);
        }

        while (!priorityQueue.isEmpty() && canSendMore(node)) {
            Node target = priorityQueue.poll();
            sendUnits(node, target, calculateTransferAmount(node, target));
        }
    }

    private boolean canSendMore(Node node) {
        return node.currentProduction > 0;
    }

    private double calculateTransferAmount(Node source, Node target) {
        return Math.min(source.currentProduction, Math.min(target.responsibility, (target.storageCapacity - target.currentStorageLevel)));
    }

    private void sendUnits(Node source, Node target, double amount) {
        source.currentProduction -= amount;
        source.currentStorageLevel = Math.max(0, source.currentStorageLevel - amount); // if needed

        target.currentConsumption += amount;
        target.currentStorageLevel += amount;
        target.responsibility -= amount; // update new responsibility
    }

    private void optimizeConnections(Node node) {
        for (Node potentialNeighbor : nodes) {
            if (!node.neighbors.contains(potentialNeighbor) && canConnect(node, potentialNeighbor)) {
                connectNodes(node, potentialNeighbor);
            }
        }
    }

    private boolean canConnect(Node n1, Node n2) {
        return n1.neighbors.size() < 8 && n2.neighbors.size() < 8;
    }

    private void connectNodes(Node n1, Node n2) {
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);
    }
}