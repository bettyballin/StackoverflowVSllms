#include <stdio.h>

int main() {
    const int MAX = 72460; // Or anything more than the highest legal value
    int inputDate, startDate, endDate;
    int inRange;

    // Example values for testing
    inputDate = 1000;
    startDate = 500;
    endDate = 1500;

    inRange = (MAX + inputDate - startDate) % MAX < 
              (MAX + endDate - startDate) % MAX;

    printf("inRange: %d\n", inRange);

    return 0;
}