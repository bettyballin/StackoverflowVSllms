#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/syscall.h>

#define NUM_THREADS 2

void* task1(void* arg) {
    while (1) {
        // Task 1 code
        printf("Task 1 is running...\n");
        sleep(1); // Simulate some work
    }
    return NULL;
}

void* task2(void* arg) {
    while (1) {
        // Task 2 code
        printf("Task 2 is running...\n");
        sleep(1); // Simulate some work
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];
    pthread_attr_t attr;
    struct sched_param param;

    // Set priority for the threads
    param.sched_priority = 0; // Priority must be in the range of the scheduling policy

    // Initialize and set thread attribute
    pthread_attr_init(&attr);
    pthread_attr_setschedpolicy(&attr, SCHED_OTHER); // Use standard scheduling policy
    pthread_attr_setschedparam(&attr, &param);

    // Create two threads with the same priority
    pthread_create(&threads[0], &attr, task1, NULL);
    pthread_create(&threads[1], &attr, task2, NULL);

    // Wait for both threads to finish
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(threads[i], NULL);
    }

    pthread_attr_destroy(&attr);
    return 0;
}