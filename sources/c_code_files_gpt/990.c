#include <time.h>

int main() {
    clock_t t0 = clock();
    double ratio = 1.0;  // Replace with your actual ratio value
    double Data_Read_Rate = 1.0;  // Replace with your actual Data_Read_Rate value

    while (((long)(1000*ratio*((long)clock()-(long)t0)) % 100) / 1000 < Data_Read_Rate);

    return 0;
}