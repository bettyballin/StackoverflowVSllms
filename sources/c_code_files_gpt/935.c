#include <pthread.h>
#include <stdbool.h>

pthread_mutex_t mtx = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;
bool condition = false;

void* thread1(void* arg) {
    pthread_mutex_lock(&mtx);
    while (!condition) {
        pthread_cond_wait(&cond, &mtx);
    }
    pthread_mutex_unlock(&mtx);
    return NULL;
}

void* thread2(void* arg) {
    pthread_mutex_lock(&mtx);
    condition = true;
    pthread_cond_signal(&cond);
    pthread_mutex_unlock(&mtx);
    return NULL;
}

int main() {
    pthread_t t1, t2;

    pthread_create(&t1, NULL, thread1, NULL);
    pthread_create(&t2, NULL, thread2, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}