#include <pthread.h>
#include <stdio.h>

// Shared variable
int shared_data = 0;

// Mutex for synchronization
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void* cpu_operation(void* arg) {
    int data = *(int*)arg;
    pthread_mutex_lock(&mutex); // Acquire cache line ownership
    shared_data = data; // Write to cache
    pthread_mutex_unlock(&mutex); // Invalidate other caches and write back to RAM
    return NULL;
}

int main() {
    pthread_t cpu1, cpu2;
    int data1 = 10;
    int data2 = 20;

    // CPU 1 operation
    pthread_create(&cpu1, NULL, cpu_operation, &data1);
    pthread_join(cpu1, NULL);

    // CPU 2 operation
    pthread_create(&cpu2, NULL, cpu_operation, &data2);
    pthread_join(cpu2, NULL);

    printf("Final shared data value: %d\n", shared_data);
    return 0;
}