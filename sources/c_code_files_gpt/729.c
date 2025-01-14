#include <stdio.h>
#include <pthread.h>
#include <unistd.h>  // For sleep

// Define the struct data_struct
typedef struct {
    void (*func_ptr)();
    int seconds;
} data_struct;

// Define a function that will be pointed to by function_pointer
void timer_expired() {
    printf("=== Timer expired!\n");
}

static void* g_start_timer(void *args)
{
    struct data_struct *data = (struct data_struct*) args;
    void (*function_pointer)() = data->func_ptr;

    int seconds = data->seconds;

    printf("=== go to sleep for %d\n", seconds);

    sleep(seconds);

    (void) (*function_pointer)();

    pthread_exit(NULL);

    return 0;
}

void start_stopwatch(struct data_struct *g_data_struct, pthread_t *thread_id)
{
    int rc;

    int seconds = g_data_struct->seconds;
    printf("=== start_stopwatch(): %d\n", seconds);

    rc = pthread_create(thread_id, NULL, g_start_timer, (void *) g_data_struct);

    if(rc)
        printf("=== Failed to create thread\n");
}

int main() {
    // Create a data_struct instance
    data_struct my_data;
    my_data.func_ptr = timer_expired;
    my_data.seconds = 5;

    pthread_t thread_id;

    // Start the stopwatch
    start_stopwatch(&my_data, &thread_id);

    // Wait for the thread to finish
    pthread_join(thread_id, NULL);

    return 0;
}