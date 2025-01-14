#include <stdio.h>

#define DEBUG 1

#ifdef DEBUG
#define myDebugPrint(...) printf(__VA_ARGS__)
#else
#define myDebugPrint(...)
#endif

int main() {
    int i = 42;
    myDebugPrint("The value is: %d\n", i);
    return 0;
}