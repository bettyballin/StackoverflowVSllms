#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

void* thread_function(void* arg) {
    printf("Thread started\n");
    while (1) {
        sleep(1);
        printf("Thread working...\n");
    }
    return NULL;
}

int main() {
    pthread_t thread;
    if (pthread_create(&thread, NULL, thread_function, NULL) != 0) {
        perror("pthread_create failed");
        exit(1);
    }

    // Sleep for 3 seconds
    sleep(3);

    // Stop the thread (not directly possible, but can use a flag or condition variable)
    // For demonstration, we cancel the thread (not the best practice)
    printf("Stopping thread...\n");
    pthread_cancel(thread);

    // Wait for the thread to finish
    pthread_join(thread, NULL);

    return 0;
}