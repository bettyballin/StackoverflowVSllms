#include <stdint.h>
#include <stdbool.h>
#include <stdio.h>

// Define buffer sizes
#define UART_RX_BUFFER_SIZE 128
#define SPI_TX_BUFFER_SIZE 256

// UART and SPI buffers
volatile uint8_t uart_rx_buffer[UART_RX_BUFFER_SIZE];
volatile uint8_t spi_tx_buffer[SPI_TX_BUFFER_SIZE];
volatile uint8_t uart_rx_head = 0;
volatile uint8_t uart_rx_tail = 0;
volatile uint8_t spi_tx_index = 0;

// Stub functions for microcontroller-specific functions
uint8_t UART_ReadByte() {
    return 0;
}

void UART_Init() {
    printf("UART initialized\n");
}

void SPI_Init() {
    printf("SPI initialized\n");
}

void SPI_WriteByte(uint8_t byte) {
    printf("SPI write byte: %u\n", byte);
}

void NVIC_EnableIRQ(uint32_t irq) {
    printf("NVIC enable IRQ: %u\n", irq);
}

bool SPI_TransferComplete() {
    return true;
}

bool SPI_WriteCycleComplete() {
    return true;
}

// UART receive interrupt handler
void UART_RX_IRQHandler(void) {
    uint8_t received_byte = UART_ReadByte(); 
    uint8_t next_head = (uart_rx_head + 1) % UART_RX_BUFFER_SIZE;
    if (next_head != uart_rx_tail) {
        uart_rx_buffer[uart_rx_head] = received_byte;
        uart_rx_head = next_head;
    } else {
        // Handle buffer overflow (if necessary)
    }
}

// SPI transfer complete interrupt handler
void SPI_TX_IRQHandler(void) {
    if (spi_tx_index < SPI_TX_BUFFER_SIZE) {
        SPI_WriteByte(spi_tx_buffer[spi_tx_index++]); 
    } else {
        // Complete SPI transfer
        spi_tx_index = 0;
    }
}

// Main function to handle data transfer
void transfer_data(void) {
    while (1) {
        if (uart_rx_tail != uart_rx_head) {
            // Copy data from UART buffer to SPI buffer
            spi_tx_buffer[spi_tx_index++] = uart_rx_buffer[uart_rx_tail];
            uart_rx_tail = (uart_rx_tail + 1) % UART_RX_BUFFER_SIZE;

            // If SPI buffer is full, start SPI transfer
            if (spi_tx_index == SPI_TX_BUFFER_SIZE) {
                SPI_WriteByte(spi_tx_buffer[0]);
                spi_tx_index = 1;
                // Wait for SPI transfer to complete and write cycle
                while (!SPI_TransferComplete()); 
                while (!SPI_WriteCycleComplete()); 
            }
        }
    }
}

int main(void) {
    // Initialize UART and SPI with appropriate configurations
    UART_Init();
    SPI_Init();

    // Enable UART and SPI interrupts
    NVIC_EnableIRQ(0);
    NVIC_EnableIRQ(1);

    // Start data transfer
    transfer_data();

    return 0;
}