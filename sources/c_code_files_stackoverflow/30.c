#include <stdio.h>
#include <time.h>

int main() {
    // Define the variables
    double ratio = 1.0; // Example value
    clock_t t0 = clock(); // Initialize t0 with the current time
    double Data_Read_Rate = 0.5; // Example value

    printf("Starting...\n");

    while ((((long)(1000*ratio*((long)clock()-(long)t0))%100)/1000.0) < Data_Read_Rate) {
        // It's a good practice to include some kind of delay or exit condition
        // to prevent the loop from consuming too much CPU.
        // For simplicity, this example does not include such measures.
    }

    printf("Done.\n");

    return 0;
}