#include <stdlib.h>
#include <time.h>
#include <string.h>

void randomize_string(char *str) {
    int n = strlen(str);

    // First seed the time to get different results each call (or you could use srand)
    struct timespec tv;
    clock_gettime(CLOCK_MONOTONIC, &tv);
    srand((time_t)tv.tv_nsec);

    for (int i = n-1; i > 0; --i) {
        // Generate a random index and swap elements at 'i' and the randomly generated index
        int j = rand() % (i + 1);
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}

int main() {
    char str[] = "Hello, World!";
    printf("Original string: %s\n", str);
    randomize_string(str);
    printf("Randomized string: %s\n", str);
    return 0;
}