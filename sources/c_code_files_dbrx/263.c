#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

// Define a struct to hold the rwlock and a shared variable
typedef struct {
    pthread_rwlock_t rwlock;
    int sharedVariable;
} SharedData;

int main() {
    // Create shared data
    SharedData *s = malloc(sizeof(SharedData));
    if (!s) {
        fprintf(stderr, "Failed to allocate memory\n");
        return EXIT_FAILURE;
    }

    // Initialize rwlock
    if (pthread_rwlock_init(&s->rwlock, NULL)) {
        fprintf(stderr, "Failed to init lock\n");
        free(s);
        return EXIT_FAILURE;
    }

    // Example: Writing
    pthread_rwlock_wrlock(&s->rwlock); // Get exclusive write permission
    s->sharedVariable = 10; // Perform the operation on the shared variable
    printf("Written: %d\n", s->sharedVariable);
    pthread_rwlock_unlock(&s->rwlock);  // Release the write lock

    // Example: Reading
    pthread_rwlock_rdlock(&s->rwlock); // Try to get shared read permission
    printf("Read: %d\n", s->sharedVariable); // Perform the reading operation on the shared variable
    pthread_rwlock_unlock(&s->rwlock);  // Release the read lock

    // Clean up
    pthread_rwlock_destroy(&s->rwlock);
    free(s);

    return EXIT_SUCCESS;
}