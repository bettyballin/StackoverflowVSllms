#include <pthread.h>
#include <stdio.h>

typedef struct {
    pthread_mutex_t mutex;
    int lock;
} test_and_set_lock;

void init_lock(test_and_set_lock *lock) {
    pthread_mutex_init(&lock->mutex, NULL);
    lock->lock = 0;
}

int test_and_set(test_and_set_lock *lock) {
    int old_value;
    pthread_mutex_lock(&lock->mutex);
    old_value = lock->lock;
    lock->lock = 1;
    pthread_mutex_unlock(&lock->mutex);
    return old_value;
}

void acquire_lock(test_and_set_lock *lock) {
    while (test_and_set(lock)) {
        // Busy wait
    }
}

void release_lock(test_and_set_lock *lock) {
    pthread_mutex_lock(&lock->mutex);
    lock->lock = 0;
    pthread_mutex_unlock(&lock->mutex);
}

int main() {
    test_and_set_lock lock;
    init_lock(&lock);

    // Example usage of the lock
    acquire_lock(&lock);
    // Critical section
    release_lock(&lock);

    pthread_mutex_destroy(&lock.mutex);
    return 0;
}