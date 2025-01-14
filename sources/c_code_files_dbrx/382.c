#include <stdint.h>

// Assuming gdResolveColor is a function that takes three unsigned char arguments
// and returns a uint32_t value. Since the implementation of gdResolveColor is not
// provided, I'll declare it as an extern function.
extern uint32_t gdResolveColor(unsigned char, unsigned char, unsigned char);

int main() {
    unsigned char red = 255;   // Maximum value for red component
    unsigned char green = 0;   // Minimum value for green component
    unsigned char blue = 128;  // Mid-range value for blue component
    uint32_t color = gdResolveColor(red, green, blue); // Resolve the combined TrueColor value
    return 0;
}