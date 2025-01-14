#include <stdio.h>

#define CACHE_SIZE 100

typedef struct {
    int input;
    int output;
    int valid;
} CacheEntry;

CacheEntry cache[CACHE_SIZE] = {{0, 0, 0}};

int costly_function(int x) {
    // Simulate a costly operation
    return x * x;
}

int foo(int x) {
    // Check cache first
    for (int i = 0; i < CACHE_SIZE; ++i) {
        if (cache[i].valid && cache[i].input == x) {
            return cache[i].output;
        }
    }

    // Perform the costly operation if not in cache
    int result = costly_function(x);

    // Store the result in cache
    for (int i = 0; i < CACHE_SIZE; ++i) {
        if (!cache[i].valid) {
            cache[i].input = x;
            cache[i].output = result;
            cache[i].valid = 1;
            break;
        }
    }

    return result;
}

int main() {
    printf("Result: %d\n", foo(10));
    printf("Result: %d\n", foo(10)); // This call should use the cached result
    return 0;
}