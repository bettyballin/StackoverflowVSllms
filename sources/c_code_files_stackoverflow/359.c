#include <avr/io.h>

// MBI5168
#define SH_DIR_OE    DDRC
#define SH_DIR_SDI   DDRC
#define SH_DIR_CLK   DDRC
#define SH_DIR_LE    DDRC

#define SH_BIT_OE    0x08
#define SH_BIT_SDI   0x01
#define SH_BIT_CLK   0x02
#define SH_BIT_LE    0x04

#define SH_PORT_OE   PORTC
#define SH_PORT_SDI  PORTC
#define SH_PORT_CLK  PORTC
#define SH_PORT_LE   PORTC

int main() {
    // Initialize ports as outputs
    SH_DIR_OE |= SH_BIT_OE;
    SH_DIR_SDI |= SH_BIT_SDI;
    SH_DIR_CLK |= SH_BIT_CLK;
    SH_DIR_LE |= SH_BIT_LE;

    // Set initial values for ports
    SH_PORT_OE &= ~(SH_BIT_OE);
    SH_PORT_SDI &= ~(SH_BIT_SDI);
    SH_PORT_CLK &= ~(SH_BIT_CLK);
    SH_PORT_LE &= ~(SH_BIT_LE);

    // Your code here...

    return 0;
}