#include <semaphore.h>

// Assuming items is an array and i is an index
void do_stuff_with(int item);

int main() {
    sem_t sem;
    int items[] = {1, 2, 3};
    int i;

    // Initialize semaphore
    sem_init(&sem, 0, 0);

    for (i = 0; i < 3; i++) {
        do_stuff_with(items[i]);
        sem_post(&sem);  // Increment semaphore
    }

    // Clean up
    sem_destroy(&sem);
    return 0;
}

void do_stuff_with(int item) {
    // Implement your functionality here
}