#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

pthread_rwlock_t rwlock = PTHREAD_RWLOCK_INITIALIZER;
int X = 0;

void* modify(void* arg) {
    pthread_rwlock_wrlock(&rwlock);
    // Modify the global variable X
    X += 1;
    printf("Modified X to %d\n", X);
    pthread_rwlock_unlock(&rwlock);
    return NULL;
}

void* read(void* arg) {
    pthread_rwlock_rdlock(&rwlock);
    // Read the global variable X
    printf("Read X as %d\n", X);
    pthread_rwlock_unlock(&rwlock);
    return NULL;
}

int main() {
    pthread_t threads[10];
    int i;

    // Create 5 modifying threads
    for (i = 0; i < 5; i++) {
        pthread_create(&threads[i], NULL, modify, NULL);
    }

    // Create 5 reading threads
    for (i = 5; i < 10; i++) {
        pthread_create(&threads[i], NULL, read, NULL);
    }

    // Join all threads
    for (i = 0; i < 10; i++) {
        pthread_join(threads[i], NULL);
    }

    pthread_rwlock_destroy(&rwlock);

    return 0;
}