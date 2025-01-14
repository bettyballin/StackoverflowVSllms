#include <stdlib.h>
#include <stdint.h>

int main() {
    uint8_t *buffer = (uint8_t *)malloc(640 * 480 * 2);
    // Process the buffer
    free(buffer);
    return 0;
}