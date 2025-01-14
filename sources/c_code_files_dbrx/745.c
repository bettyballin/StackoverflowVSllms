#include <pthread.h>
#include <stdio.h>
#include <unistd.h>

// Declare the global mutex
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;

// Shared resource example
int sharedCounter = 0;

// Function to be executed by threads
void* myFunc(void* arg) {
    // Lock the mutex so that no other threads can use it.
    pthread_mutex_lock(&lock);

    // Simulate some work on the shared resource
    for(int i = 0; i < 100000; ++i) {
        sharedCounter++;
    }

    // Unlock the mutex when you are done, allowing other threads in.
    pthread_mutex_unlock(&lock);

    return NULL;
}

int main() {
    pthread_t thread1, thread2;

    // Create two threads
    pthread_create(&thread1, NULL, myFunc, NULL);
    pthread_create(&thread2, NULL, myFunc, NULL);

    // Wait for both threads to finish
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("Final value of sharedCounter: %d\n", sharedCounter);

    return 0;
}