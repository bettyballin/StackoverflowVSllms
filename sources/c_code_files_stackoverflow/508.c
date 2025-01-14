#define DEBUG // Define DEBUG to include the code within #if (DEBUG)

#include <stdio.h>

int main() {
#if (DEBUG)
    // Debug Stuff
    printf("This is debug stuff.\n");
#endif
    return 0;
}