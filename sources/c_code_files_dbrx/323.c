#include <time.h>

void f1(int duration) {
    clock_t start, end;
    double cpu_time_used;
    start = clock();
    while (clock() - start <= duration*CLOCKS_PER_SEC); // active sleep loop
}

int main() {
    int duration = 5; // Example duration in seconds
    f1(duration);
    return 0;
}