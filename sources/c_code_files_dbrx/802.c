#include <stdatomic.h>

// assuming p is a 64-bit pointer on a 64-bit machine, this should be atomic
atomic(void *) shared;

int main() {
    void *expected = NULL;
    void *desired = NULL; // initialize desired as needed

    while (!atomic_compare_exchange_strong(&shared, &expected, desired)) {
        expected = shared; // update expected for the next iteration
        // Do nothing and repeat the loop
    }

    return 0;
}