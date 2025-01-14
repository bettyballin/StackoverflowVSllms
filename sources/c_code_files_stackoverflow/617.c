#include <stdio.h>
#include <stdint.h>
#include <string.h>

int main() {
    uint8_t dstbuff[10];
    uint8_t srcbuff[10];

    // Initialize srcbuff with some values
    for (int i = 0; i < sizeof(srcbuff); i++) {
        srcbuff[i] = i;
    }

    errno_t e = memcpy_s(dstbuff, sizeof(dstbuff), srcbuff, sizeof(srcbuff));

    if (e != 0) {
        printf("Error occurred during memcpy_s: %d\n", e);
    } else {
        printf("memcpy_s successful\n");
    }

    return 0;
}