#include <semaphore.h>

int main() {
    sem_t sem;
    sem_init(&sem, 0, 1); // initialize semaphore

    sem_wait(&sem); // wait on semaphore

    sem_destroy(&sem); // destroy semaphore
    return 0;
}