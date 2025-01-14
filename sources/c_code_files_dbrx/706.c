#include <pthread.h>
#include <stdio.h>

int main() {
    pthread_cond_t write_it = PTHREAD_COND_INITIALIZER;
    int rc = pthread_cond_signal(&write_it);
    if(rc) {
        printf("Error signaling condition: %d\n", rc);
        // Handle error.
    }
    return 0;
}