#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <sys/wait.h>

#define SHM_SIZE 4096

int main() {
    // Create a shared memory object
    int shm_fd = shm_open("/myshm", O_CREAT | O_RDWR, 0666);
    if (shm_fd == -1) {
        perror("shm_open");
        exit(EXIT_FAILURE);
    }

    // Configure the size of the shared memory object
    if (ftruncate(shm_fd, SHM_SIZE) == -1) {
        perror("ftruncate");
        exit(EXIT_FAILURE);
    }

    // Map the shared memory object
    void *shm_ptr = mmap(0, SHM_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
    if (shm_ptr == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    // Write some data to the shared memory
    sprintf((char *)shm_ptr, "Hello from parent process!");

    pid_t pid = fork();
    if (pid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Child process
        execlp("./child_program", "./child_program", NULL);
        perror("execlp");
        exit(EXIT_FAILURE);
    } else {
        // Parent process
        wait(NULL);  // Wait for child process to finish
        printf("Child process finished\n");

        // Clean up shared memory
        if (munmap(shm_ptr, SHM_SIZE) == -1) {
            perror("munmap");
        }
        if (shm_unlink("/myshm") == -1) {
            perror("shm_unlink");
        }
    }

    return 0;
}