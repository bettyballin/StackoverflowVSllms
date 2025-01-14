import java.lang.String;
public class NewRenoCongestionControlAlgorithm {
    int cwnd = 1; // Initial cwnd after timeout
    int ssthresh;
    int smss = 536; // Example SMSS size
    int expectedAckSequence;
    int flightSize;
    int rwnd;

    void onRetransmitTimeout() {
        cwnd = 1;
        retransmitOldestPacket();
        updateRTO(); // Double the RTO as per New Reno rules
    }

    void onAcknowledgmentReceived(int acknowledgedSeqNumber) {
        if (acknowledgedSeqNumber >= expectedAckSequence) {
            cwnd += smss; // Increase cwnd by SMSS for each new ACK
            sendNewData(); // Check conditions and send more data if feasible
        }
    }

    void retransmitOldestPacket() {
        // Retransmit the oldest unacknowledged segment
    }

    void updateRTO() {
        // Update RTO to be twice the current value or some calculated value
    }

    void sendNewData() {
        while (flightSize < Math.min(cwnd, rwnd)) {
            sendPacket();
        }
    }

    void sendPacket() {
        // send a packet
    }

    public static void main(String[] args) {
    }
}