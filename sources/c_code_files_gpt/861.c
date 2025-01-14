#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

// Define the missing struct and function
typedef struct {
    int seconds;
    void (*func_ptr)(void);
} data_struct;

void* stopwatch_thread(void* arg) {
    data_struct* data = (data_struct*) arg;
    sleep(data->seconds);
    data->func_ptr();
    return NULL;
}

void start_stopwatch(data_struct* data, pthread_t* thread_id) {
    pthread_create(thread_id, NULL, stopwatch_thread, data);
}

/* call this when the time expires */
void timeout_cb() {
    printf("=== your time is up, run some job here ===\n");
}

int main() {
    data_struct* g_data_struct = (data_struct*) calloc(1, sizeof(*g_data_struct));

    if(!g_data_struct) {
        printf("=== failed to allocate memory ===\n");
        return 0;
    }

    g_data_struct->seconds = 3;
    g_data_struct->func_ptr = timeout_cb;

    pthread_t thread_id;

    start_stopwatch(g_data_struct, &thread_id);

    pthread_join(thread_id, NULL);  // Wait for the thread to finish

    free(g_data_struct);  // Free the memory after the thread has finished
    printf("=== End of Program - all threads in ===\n");

    return 0;
}