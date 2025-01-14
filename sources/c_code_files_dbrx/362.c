#include <pthread.h>
#include <stdio.h>

void* printSome(void* arg) {
    printf("Hello from new thread!\n");
    return NULL;
}

void spawnThread(void (*func)(void*)) {
    pthread_t thread;
    pthread_create(&thread, NULL, func, NULL);
    pthread_join(thread, NULL);
}

int main() {
    spawnThread(printSome);
    return 0;
}