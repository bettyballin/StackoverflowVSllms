#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <semaphore.h>
#include <fcntl.h>

#define MAX_CHILDREN 10

void do_stuff_with(int item) {
    printf("%d\n", item);  // Added newline character
    sleep(1); // Simulate work
}

int main() {
    int items[101];
    for (int i = 0; i <= 100; i++) {
        items[i] = i;
    }

    sem_t *sem = sem_open("/fork_semaphore", O_CREAT, 0644, MAX_CHILDREN);
    if (sem == SEM_FAILED) {
        perror("sem_open");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i <= 100; i++) {
        sem_wait(sem);  // Decrement semaphore

        pid_t pid = fork();
        if (pid == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        } else if (pid == 0) {
            // Child process
            do_stuff_with(items[i]);
            sem_post(sem);  // Increment semaphore
            exit(0);
        }
    }

    // Wait for all children to finish
    for (int i = 0; i <= 100; i++) {
        wait(NULL);
    }

    sem_close(sem);
    sem_unlink("/fork_semaphore");

    return 0;
}