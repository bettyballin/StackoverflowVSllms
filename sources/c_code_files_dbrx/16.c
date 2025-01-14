#include <stdint.h>

static uint16_t currentId = 0; // initialize to something, like zero or highest used so far.
                               // This could be stored in flash memory.

uint16_t newId() { 
    if (currentId == UINT16_MAX) {
        // handle overflow error, for example:
        // while (1); // loop forever
        // or
        // return an error value
        // or
        // reset currentId to a default value
    } else {
        return currentId++; 
    }
}