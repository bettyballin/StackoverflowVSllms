#include <stdint.h>
#include <stdio.h>

// Define constants
#define RXBUFFERSIZE 256 // Example buffer size, adjust as necessary but keep within limits specified
#define BUFF_COUNT 10    // Example minimum buffer count, adjust as necessary

volatile uint8_t rxBuffer[RXBUFFERSIZE];
uint32_t rxTail, rxHead;

void uart_isr_sim(uint8_t recv) {
    // Simulated UART Receive Interrupt Service Routine
    // Save received character and bump tail index. Protect against wrap around.
    rxBuffer[rxTail] = recv; // Adding new Data at current Tail position.
    rxTail = ((rxTail + 1) & (RXBUFFERSIZE - 1)); // Increment Tail (write pointer).
}

int main() {
    // Initialize rxTail and rxHead for demonstration
    rxTail = 0;
    rxHead = 0;

    // Simulate receiving some data
    uint8_t exampleData = 'A';
    uart_isr_sim(exampleData);

    // Example: Print the first character in the buffer to verify
    printf("Received: %c\n", rxBuffer[0]);

    return 0;
}