#include <pthread.h>
#include <stdio.h>

// Define a global pointer and a mutex
void *global_ptr = NULL;
pthread_mutex_t ptr_mutex = PTHREAD_MUTEX_INITIALIZER;

void update_pointer(void *new_value) {
    pthread_mutex_lock(&ptr_mutex);
    global_ptr = new_value;
    pthread_mutex_unlock(&ptr_mutex);
}

void *read_pointer() {
    void *value;
    pthread_mutex_lock(&ptr_mutex);
    value = global_ptr;
    pthread_mutex_unlock(&ptr_mutex);
    return value;
}

void *thread_function(void *arg) {
    // Thread work that reads the global pointer
    void *ptr = read_pointer();
    // Do something with ptr...
    return NULL;
}

int main() {
    pthread_t thread1, thread2;

    // Create threads
    pthread_create(&thread1, NULL, thread_function, NULL);
    pthread_create(&thread2, NULL, thread_function, NULL);

    // Update the global pointer in main thread
    int new_value = 42;
    update_pointer(&new_value);

    // Wait for threads to finish
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    return 0;
}