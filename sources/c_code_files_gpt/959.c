#include <stdio.h>

typedef struct {
    volatile int lock;
} spinlock_t;

void spin_lock(spinlock_t *lock) {
    while (__sync_lock_test_and_set(&lock->lock, 1)) {
        // Busy-wait (spin)
    }
}

void spin_unlock(spinlock_t *lock) {
    __sync_lock_release(&lock->lock);
}

int main() {
    spinlock_t my_lock = {0}; // Initialize the lock to unlocked state

    printf("Attempting to lock...\n");
    spin_lock(&my_lock);
    printf("Locked. Performing some work...\n");

    // Simulate some work
    for (int i = 0; i < 5; i++) {
        printf("Working...\n");
    }

    printf("Unlocking...\n");
    spin_unlock(&my_lock);
    printf("Unlocked.\n");

    return 0;
}