#include <stdio.h>

// Define constants
#define MSS 1000  // Maximum Segment Size
#define initial_ssthresh 64000  // Initial slow-start threshold
#define initial_RTO 1000  // Initial Retransmission Timeout

// Function prototypes
void retransmit(int packet);
void restart_retransmission_timer(int RTO);
int acknowledges_new_data(int ack);

int main() {
    int cwnd = 1 * MSS;  // Congestion window
    int ssthresh = initial_ssthresh;  // Slow-start threshold
    int RTO = initial_RTO;  // Retransmission Timeout
    int oldest_unacknowledged_packet = 0;  // Oldest unacknowledged packet
    int data_to_be_sent = 1;  // Flag to indicate data to be sent
    int ack = 0;  // ACK received

    while (data_to_be_sent) {
        // Simulate timeout occurrence
        int timeout_occurs = 0;  // Replace with actual timeout detection logic
        if (timeout_occurs) {
            // Timeout detected, retransmit oldest unacknowledged packet
            retransmit(oldest_unacknowledged_packet);
            cwnd = 1 * MSS;  // Reset cwnd to 1 MSS
            RTO = RTO * 2;   // Double the RTO
            restart_retransmission_timer(RTO);
        }
        else if (ack) {
            if (acknowledges_new_data(ack)) {
                // New data acknowledged, increase cwnd
                if (cwnd < ssthresh) {
                    // Slow Start phase
                    cwnd += 1 * MSS;
                } else {
                    // Congestion Avoidance phase
                    cwnd += (1 * MSS * MSS) / cwnd;
                }
            }
        }

        // Update data_to_be_sent and ack for the next iteration
        data_to_be_sent = 0;  // Replace with actual logic to check if data is left to be sent
        ack = 0;  // Replace with actual logic to receive ACK
    }

    return 0;
}

// Function definitions
void retransmit(int packet) {
    printf("Retransmitting packet %d\n", packet);
}

void restart_retransmission_timer(int RTO) {
    printf("Restarting retransmission timer with RTO %d\n", RTO);
}

int acknowledges_new_data(int ack) {
    // Replace with actual logic to check if ACK acknowledges new data
    return 1;
}