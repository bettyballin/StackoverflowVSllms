#include <unistd.h>

#define PORT 0x40020400 // Address of GPIO_PORTB
#define PIN 0x20        // assuming pin no. 5 is used for LED

volatile unsigned long *gpio = (unsigned long*) PORT;

int main() {
    // turn on the led in your code where-ever required
    *gpio |= PIN; // turn on the led
    usleep(1000); // wait for 1 millisecond
    *gpio &= ~PIN; // turn off the led
    return 0;
}