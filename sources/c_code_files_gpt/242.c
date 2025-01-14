#include <time.h>
#include <stdio.h>

// Adding a simple operation to demonstrate timing functionality
void some_function() {
    int i;
    for (i = 0; i < 100000000; i++) {
        // Do something simple, e.g., increment i (already done in the loop)
    }
}

int main() {
    clock_t start, end;
    double cpu_time_used;

    start = clock();
    some_function();
    end = clock();

    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("some_function() took %f seconds to execute\n", cpu_time_used);

    return 0;
}