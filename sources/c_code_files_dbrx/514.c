#include <pthread.h>

int main() {
    pthread_cond_t condition;
    pthread_cond_init(&condition, NULL);
    // Your code here...
    pthread_cond_destroy(&condition); // Don't forget to destroy the condition variable
    return 0;
}