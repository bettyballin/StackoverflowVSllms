#include <stdint.h>
#include <stdio.h>

// Define the buffer size and mask
#define BUFF_SIZE 256
#define BUFF_COUNT_MASK (BUFF_SIZE - 1)

// Define the RX buffers
uint8_t rxBuffer1[BUFF_SIZE], rxBuffer2[BUFF_SIZE];
volatile uint32_t rxBufferCnt = 0;  // Index into the ring buffer
uint8_t rxBuffers[2][BUFF_SIZE];    // 2D array to hold the RX buffers
uint8_t rxData = 0;                 // Sample received data

int main() {
    // Initialize the RX buffers
    for (int i = 0; i < BUFF_SIZE; i++) {
        rxBuffer1[i] = 0;
        rxBuffer2[i] = 0;
        rxBuffers[0][i] = 0;
        rxBuffers[1][i] = 0;
    }

    // Simulate the UART receive interrupt service routine (ISR)
    for (int i = 0; i < 10; i++) {  // Simulate 10 received data bytes
        rxData = i;                 // Sample received data
        rxBufferCnt = (rxBufferCnt + 1) & BUFF_COUNT_MASK;  // Increment buffer count and take modulo
        rxBuffers[0][rxBufferCnt] = rxData;                // Assign new received data to the buffer
        printf("Received data: %d, Buffer count: %d\n", rxData, rxBufferCnt);
    }

    return 0;
}