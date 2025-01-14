#include <stdio.h>
#include <stdlib.h>

#define WINDOW_SIZE 5

int base = 0; // Base of send window
int nextSeqNum = 0; // Next sequence number to be sent
int expectedSeqNum = 0; // Expected sequence number on receiver side

// Function prototypes
void sendPacket(int seqNum);
void startTimer();
void waitForACKsOrTimeout();
void sendACK(int seqNum);
void deliverData(void* packet);
void sendCumulativeACK(int seqNum);
void* receivePacket();

int main() {
    // Sender side
    while (1) {
        while ((nextSeqNum - base < WINDOW_SIZE) && (1)) { // Replace (!EOF) with (1) for simplicity
            sendPacket(nextSeqNum);
            startTimer();
            nextSeqNum++;
        }
        // If end of file, exit loop and close connection
        // For simplicity, assume we don't reach EOF
        waitForACKsOrTimeout();
    }

    // Receiver side (commented out to avoid conflict with sender side)
    //while (1) {
    //    int expectedSeqNum = base; // Expected sequence number
    //    void* packet;
    //    while ((packet = receivePacket()) != NULL) {
    //        if (*((int*)packet) == expectedSeqNum) {
    //            sendACK(expectedSeqNum);
    //            deliverData(packet);
    //            expectedSeqNum++;
    //        } else {
    //            // Throw away packet
    //        }
    //    }
    //    // Send a cumulative ACK for all packets up to the last correctly received seq num
    //    sendCumulativeACK(base);
    //}

    return 0;
}

// Function implementations (empty for simplicity)
void sendPacket(int seqNum) {}
void startTimer() {}
void waitForACKsOrTimeout() {}
void sendACK(int seqNum) {}
void deliverData(void* packet) {}
void sendCumulativeACK(int seqNum) {}
void* receivePacket() {
    return NULL;
}