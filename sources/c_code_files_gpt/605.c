#include <pthread.h>
#include <stdio.h>

// Define a mutex to serve as our critical section
pthread_mutex_t cs = PTHREAD_MUTEX_INITIALIZER;

int value1 = 0;
int value2 = 0;
int oldValue = 0;
int newValue = 10;

int main() {
    // In the code where you need to update values atomically
    pthread_mutex_lock(&cs);
    value1++;
    value2++;
    oldValue = newValue;
    pthread_mutex_unlock(&cs);

    printf("value1: %d, value2: %d, oldValue: %d\n", value1, value2, oldValue);

    // Cleanup
    pthread_mutex_destroy(&cs);

    return 0;
}