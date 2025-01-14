import java.util.List;
import java.util.ArrayList;

public class SelectiveAcknowledgementGenerator {
    // Example Pseudo-code for SACK generation
    public List<Integer> generateSelectiveAck(List<Boolean> receivedPackets) {
        List<Integer> sackList = new ArrayList<>();
        for(int i = 0; i < receivedPackets.size(); i++) {
            if (!receivedPackets.get(i)) {
                sackList.add(i);
            }
        }
        return sackList;
    }

    public static void main(String[] args) {
    }
}