#include <stdio.h>
#include <stdlib.h>

int main() {
    const char *hexString = "0xfffffff";
    long int number = strtol(hexString, NULL, 16);
    
    printf("The integer value is: %ld\n", number);

    return 0;
}