#include <stdio.h>
#include <stdlib.h>

typedef volatile int spinlock_t;

void spinlock_init(spinlock_t *lock) {
    *lock = 0;
}

void spinlock_lock(spinlock_t *lock) {
    while (__sync_lock_test_and_set(lock, 1)) {
        while (*lock) {
            // Busy wait
        }
    }
}

void spinlock_unlock(spinlock_t *lock) {
    __sync_lock_release(lock);
}

void critical_section() {
    // Code for critical section
}

int main() {
    spinlock_t lock;
    spinlock_init(&lock);

    spinlock_lock(&lock);
    critical_section();
    spinlock_unlock(&lock);

    return 0;
}