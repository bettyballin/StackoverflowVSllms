#include <pthread.h>
#include <stdio.h>

// Declare the mutex and condition variable
pthread_mutex_t lock_it = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t write_it = PTHREAD_COND_INITIALIZER;

void* send_segment(void *v) {
    for(;;) {
        pthread_mutex_lock(&lock_it);
        printf("s1\n");
        printf("s2\n");
        pthread_cond_wait(&write_it, &lock_it); // This will unlock the mutex and wait for a signal.
                            // When it receives one, it will lock again and continue execution from this point onward.
        printf("s3\n");
        printf("s4\n");
        printf("s5\n");
        pthread_mutex_unlock(&lock_it);  // Unlock the mutex outside your condition variable wait loop to allow other threads waiting for signal some time.
    }
    return 0;
}

int main() {
    pthread_t thread;
    pthread_create(&thread, NULL, send_segment, NULL);
    pthread_join(thread, NULL);
    return 0;
}