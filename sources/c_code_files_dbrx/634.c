#include <pthread.h>

// Assuming g_start_timer is a function with the following signature:
void* g_start_timer(void* arg);

// Assuming g_data_struct is a global variable
void* g_data_struct;

int main() {
    pthread_t thread_id;
    int rc;

    rc = pthread_create(&thread_id, NULL, g_start_timer, (void *)g_data_struct);

    // You might want to check the return value of pthread_create
    if (rc != 0) {
        // Handle error
    }

    // You might want to join the thread
    pthread_join(thread_id, NULL);

    return 0;
}