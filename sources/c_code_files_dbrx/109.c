#include <stdio.h>

int main() {
    char myArray[] = {0x00, 0x11, 0x22};
    for (unsigned int i=0; i<sizeof(myArray); ++i) {
        printf("Element %d is %X\n", i, (unsigned char)myArray[i]);
    }
    return 0;
}