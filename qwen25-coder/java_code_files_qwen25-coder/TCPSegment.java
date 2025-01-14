import java.lang.String;
public class TCPSegment {
    private int sequenceNumber; // SEQ: Identifies the first byte of data after what has been acknowledged
    private int acknowledgmentNumber; // ACK: Acknowledges receipt up to, but not including, this sequence number

    public TCPSegment(int seq, int ack) {
        this.sequenceNumber = seq;
        this.acknowledgmentNumber = ack;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public int getAcknowledgmentNumber() {
        return acknowledgmentNumber;
    }

	public static void main(String[] args) {
	}
}