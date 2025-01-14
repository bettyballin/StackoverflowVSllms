#include <stdint.h>

// Assuming USART_CHANNEL is an array of structures
typedef struct {
    uint32_t CSR;
    // Other members...
} USART_Channel;

USART_Channel USART_CHANNEL[];

// Assuming Serial_Receive_Queue is a global variable
uint32_t Serial_Receive_Queue;

void USART_Process_Interrupt(int Channel) {
    // Test for a receive interrupt
    if (USART_CHANNEL[Channel]->CSR & (1 << 0)) { // Assuming rxrdy is bit 0
        // Receive interrupt handling code goes here...
    }
}