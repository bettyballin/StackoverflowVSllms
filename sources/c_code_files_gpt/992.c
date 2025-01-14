#include <sys/mman.h>
    #include <fcntl.h>
    #include <unistd.h>
    #include <stdio.h>
    #include <stdlib.h>

    int main() {
        const char *name = "/shared_memory";
        int shm_fd = shm_open(name, O_CREAT | O_RDWR, 0660); // Set permissions to user/group read-write
        if (shm_fd == -1) {
            perror("shm_open");
            exit(1);
        }

        // Only allow specific processes to access the shared memory based on UID/GID checks
        // Implement your own access control logic here
        // e.g., check if the process belongs to a specific user or group before accessing the memory

        // Close the shared memory segment
        close(shm_fd);
        return 0;
    }