#include <pthread.h>
#include <stdio.h>

typedef struct {
    int head;
    int tail;
} my_queue_t;

my_queue_t queue;

// Initialize sync primitives such as pthreads' mutex and cond var
static pthread_mutex_t mtx = PTHREAD_MUTEX_INITIALIZER;
static pthread_cond_t cv = PTHREAD_COND_INITIALIZER;

void *consumer(void *arg) {
    // Acquire lock on the shared resource
    pthread_mutex_lock(&mtx);

    while (queue.head == queue.tail) {
        // Release lock and wait for signal
        pthread_cond_wait(&cv, &mtx);
    }

    // Update tail of your queue as consumer processes data here...
    queue.tail++;

    // Broadcast to the producer thread that a slot is free
    pthread_cond_signal(&cv);

    pthread_mutex_unlock(&mtx);
    return NULL;
}

int main() {
    pthread_t thread;
    queue.head = 0;
    queue.tail = 0;

    pthread_create(&thread, NULL, consumer, NULL);
    pthread_join(thread, NULL);

    return 0;
}