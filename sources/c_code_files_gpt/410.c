#include <semaphore.h>

int main() {
    sem_t *sem;
    // Assuming sem is initialized and opened somewhere in the code
    sem_close(sem);
    sem_unlink("/fork_semaphore");
    return 0;
}