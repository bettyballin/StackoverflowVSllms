#include <stdio.h>

// Spinlock using Test-and-Set
int lock = 0;

void acquire_lock() {
    while (__sync_lock_test_and_set(&lock, 1)) {
        // Busy-wait (spin) until the lock is acquired
    }
}

void release_lock() {
    __sync_lock_release(&lock);
}

int main() {
    acquire_lock();
    printf("Lock acquired\n");
    release_lock();
    printf("Lock released\n");
    return 0;
}