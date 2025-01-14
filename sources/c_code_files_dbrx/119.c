#include <time.h>

int main() {
    clock_t t0 = clock();
    double ratio = 1.0; // replace with your desired ratio
    double Data_Read_Rate = 1.0; // replace with your desired data read rate

    while(((1000 * ratio * ((long)clock() - (long)t0)) % 100 ) / 1000  < Data_Read_Rate);

    return 0;
}