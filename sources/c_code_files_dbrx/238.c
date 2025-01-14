#include <stdio.h>

// Define DISABLE_FEATURE to test the conditional compilation
// #define DISABLE_FEATURE

int main() {
#if defined(DISABLE_FEATURE)
    // Code to disable feature here.
    printf("The feature is disabled.\n");
#else
    // All other functionality that's always enabled goes here.
    printf("The feature is enabled.\n");
#endif

    return 0;
}