#include <pthread.h>
#include <stdio.h>
#include <unistd.h>

// Define the structure
struct data_struct
{
    int seconds;
    void (*func_ptr)(void);
};

// Function to be executed by the thread
void timer_expired(void)
{
    printf("Time's up!\n");
}

// Function to start the stopwatch
void* start_stopwatch(void *arg)
{
    struct data_struct *data = (struct data_struct *)arg;
    sleep(data->seconds);
    data->func_ptr();
    return NULL;
}

int main()
{
    struct data_struct g_data_struct;
    pthread_t thread_id;

    g_data_struct.seconds = 5;  // Set the timer for 5 seconds
    g_data_struct.func_ptr = timer_expired;

    pthread_create(&thread_id, NULL, start_stopwatch, &g_data_struct);
    pthread_join(thread_id, NULL);

    return 0;
}