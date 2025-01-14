#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_SIZE 10000000

int main() {
    int *array = (int *)malloc(ARRAY_SIZE * sizeof(int));
    if (array == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        return 1;
    }

    // Initialize array
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = i;
    }

    clock_t start = clock();
    
    // Access array elements
    long long sum = 0;
    for (int i = 0; i < ARRAY_SIZE; i++) {
        sum += array[i];
    }
    
    clock_t end = clock();
    
    printf("Sum: %lld\n", sum);
    printf("Time taken: %lf seconds\n", (double)(end - start) / CLOCKS_PER_SEC);

    free(array);
    return 0;
}