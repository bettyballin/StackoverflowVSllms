#include <stdio.h>

#define MAXIMUM_ALLOWED_PORT_NUMBER 0xFFFFU // this is hexadecimal for 65535 decimal

int main() {
    printf("The maximum allowed port number is: %u\n", MAXIMUM_ALLOWED_PORT_NUMBER);
    return 0;
}