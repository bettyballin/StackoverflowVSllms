import java.util.List;
import java.util.ArrayList;

public class DataRedistributor {

    public void redistributeData(List<Node> children) {
        int totalFiles = 0;
        List<Node> excessNodes = new ArrayList<>();
        List<Node> deficientNodes = new ArrayList<>();

        // Calculate total files and determine excess/deficient nodes
        for (Node child : children) {
            totalFiles += child.dataLoad;
        }
        int avg = totalFiles / children.size();

        for (Node child : children) {
            if (child.dataLoad > avg + 1) {
                excessNodes.add(child);
            } else if (child.dataLoad < avg) {
                deficientNodes.add(child);
            }
        }

        // Distribute from excess to deficient
        int balanceIndex = 0;
        for (int i = 0; i < excessNodes.size(); i++) {
            Node sender = excessNodes.get(i);
            while (sender.dataLoad > avg + 1 && balanceIndex < deficientNodes.size()) {
                Node receiver = deficientNodes.get(balanceIndex);
                int filesToSend = Math.min(sender.dataLoad - (avg + 1), avg - receiver.dataLoad);

                sender.dataLoad -= filesToSend;
                receiver.dataLoad += filesToSend;

                if (receiver.dataLoad == avg) {
                    balanceIndex++;
                }
            }
        }
    }
}

class Node {
    public int dataLoad;

    public Node(int dataLoad) {
        this.dataLoad = dataLoad;
    }
}