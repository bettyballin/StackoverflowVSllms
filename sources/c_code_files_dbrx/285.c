#include <stdio.h>

int main() {
    int someValue = 5; // Example value
    int myInt[20];
    
    for (int i = 0; i < 25; ++i) { // Buffer Overflow occurs in this loop, as 25 > 20
        if (i >= 20) {
            printf("Warning: Attempting to write outside the bounds of the array at index %d.\n", i);
        } else {
            myInt[i] = someValue * i;
            printf("Assigned value %d to myInt[%d]\n", myInt[i], i);
        }
    }
    
    return 0;
}