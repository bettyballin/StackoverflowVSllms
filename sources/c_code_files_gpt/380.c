#include <pthread.h>
#include <stdio.h>
#include <unistd.h>

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void* threadFunction(void* arg) {
    printf("Thread %s is trying to lock the mutex...\n", (char*)arg);
    lock();
    printf("Thread %s has locked the mutex. Sleeping for 2 seconds...\n", (char*)arg);
    sleep(2); // Simulate some work
    printf("Thread %s is unlocking the mutex...\n", (char*)arg);
    unlock();
    pthread_exit(NULL);
}

void lock() {
    pthread_mutex_lock(&mutex);
}

void unlock() {
    pthread_mutex_unlock(&mutex);
}

int main() {
    pthread_t thread1, thread2;
    char* arg1 = "1";
    char* arg2 = "2";

    pthread_create(&thread1, NULL, threadFunction, arg1);
    pthread_create(&thread2, NULL, threadFunction, arg2);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    return 0;
}