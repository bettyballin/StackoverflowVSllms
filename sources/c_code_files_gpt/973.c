#include <stdio.h>

int main() {
    unsigned char myArray[] = { 0x00, 0x11, 0x22 };

    for (int i = 0; i < sizeof(myArray); i++) {
        printf("myArray[%d] = 0x%02x\n", i, myArray[i]);
    }

    return 0;
}