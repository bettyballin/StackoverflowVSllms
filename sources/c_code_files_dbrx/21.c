#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/wait.h> // Include wait.h for wait() function

int main() {
    // Create shared memory with size (1024 * sizeof(char))
    void *shared_mem = mmap(NULL, 1024, PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1, 0);

    if (shared_mem == MAP_FAILED) {
        perror("mmap");
        return 1;
    }

    // Write to shared memory in parent process
    sprintf((char*)shared_mem,"Hello from parent");

    pid_t child_pid = fork();
    if(child_pid == -1) {
        perror("fork");
        munmap(shared_mem, 1024);
        return 1;
    }

    if(!child_pid) {
        // Execute child process and read shared memory in it
        // Please replace "/path/to/child" with your actual executable path
        execl("/path/to/child", "child", (char*)NULL);
        perror("execl"); // execl only returns if an error occurs
        return 1;
    } else {
        printf("Parent waiting for child to finish...\n");
        wait(NULL);
        munmap(shared_mem, 1024); // Unmap shared memory after child process finishes executing.
        return 0;
    }
}