#include <stdio.h>
#include <stdint.h>

int main(void) {
    volatile uint32_t i = 0;

    while (i == 0) {
        // do nothing, just wait until `i` is changed by an external source
    }

    return 0;
}