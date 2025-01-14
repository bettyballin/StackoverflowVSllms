#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

// Define the data_struct
typedef struct data_struct {
    // Example member
    int some_data;
} data_struct;

// Function to start a stopwatch
void* start_stopwatc(void* arg) {
    // Cast the argument to the expected type
    struct data_struct* g_data_struct = (struct data_struct*) arg;
    
    // Basic example: print a message and return the thread id
    printf("Starting stopwatch with data: %d\n", g_data_struct->some_data);
    
    // Assuming the intention is to return the thread ID,
    // but since this function itself runs in a new thread,
    // we simply return the address of a local variable as an example.
    // In a real application, you'd likely return something meaningful.
    pthread_t thread_id = pthread_self();
    return (void*) thread_id;
}

int main() {
    // Initialize the data structure
    struct data_struct data;
    data.some_data = 5;
    
    // Create a thread
    pthread_t thread;
    pthread_create(&thread, NULL, start_stopwatc, &data);
    
    // Wait for the thread to finish
    void* result;
    pthread_join(thread, &result);
    
    // Example: print the result (thread ID)
    printf("Thread ID returned: %p\n", result);
    
    return 0;
}