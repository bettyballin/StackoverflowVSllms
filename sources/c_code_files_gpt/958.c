#include <time.h>

int main() {
    clock_t t0 = clock(); // initialize t0
    double ratio = 1.0; // initialize ratio
    double Data_Read_Rate = 0.5; // initialize Data_Read_Rate

    while (((long)(1000*ratio*((long)clock()-(long)t0)) % 100) / 1000 < Data_Read_Rate) {
        // Loop body (if needed) or continue statement
    }

    return 0;
}