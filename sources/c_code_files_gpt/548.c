#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h> // Added for shm_open

#define SHM_SIZE 4096

int main() {
    // Open the shared memory object
    int shm_fd = shm_open("/myshm", O_RDWR, 0666);
    if (shm_fd == -1) {
        perror("shm_open");
        exit(EXIT_FAILURE);
    }

    // Map the shared memory object
    void *shm_ptr = mmap(0, SHM_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
    if (shm_ptr == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    // Read and print the data from the shared memory
    printf("Child process read: %s\n", (char *)shm_ptr); // Added newline character

    // Clean up
    if (munmap(shm_ptr, SHM_SIZE) == -1) {
        perror("munmap");
    }
    close(shm_fd); // Added to close the shm_fd

    return 0;
}