#include <pthread.h>
#include <stdlib.h>

// Assuming g_start_timer and g_data_structure are defined elsewhere
void* g_start_timer;
void* g_data_structure;

// Assuming start_stopwatch function is defined elsewhere
int* start_stopwatch(void* timer, void* data_structure);

int main() {
    int *thread_id = start_stopwatch(g_start_timer, g_data_structure);
    pthread_join(*thread_id, NULL); // waits for thread to finish execution
    free(g_data_structure);
    return 0;
}