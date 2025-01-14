#include <pthread.h>
#include <stdio.h>

pthread_mutex_t lock_it = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t write_it = PTHREAD_COND_INITIALIZER;
int ready = 0; // Shared state variable

void* send_segments(void *v) {
    for (;;) {
        pthread_mutex_lock(&lock_it);
        while (!ready) {
            pthread_cond_wait(&write_it, &lock_it);
        }
        // Reset ready state
        ready = 0;
        printf("s1\n");
        printf("s2\n");
        printf("s3\n");
        printf("s4\n");
        printf("s5\n");
        pthread_mutex_unlock(&lock_it);
    }
    return NULL;
}

void* recv_acks(void *v) {
    for (;;) {
        pthread_mutex_lock(&lock_it);
        printf("r1\n");
        ready = 1; // Set ready state
        pthread_cond_signal(&write_it);
        printf("r2\n");
        pthread_mutex_unlock(&lock_it);
    }
    return NULL;
}

int main(int argc, char** argv) {
    pthread_t t_send_segments, t_recv_acks;

    pthread_create(&t_send_segments, NULL, send_segments, NULL);
    pthread_create(&t_recv_acks, NULL, recv_acks, NULL);

    pthread_join(t_send_segments, NULL);
    pthread_join(t_recv_acks, NULL);

    pthread_mutex_destroy(&lock_it);
    pthread_cond_destroy(&write_it);

    return 0;
}