#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <fcntl.h>  // For O_* constants
#include <sys/stat.h> // For mode constants
#include <time.h> // For srand and rand

// Define the function f(x)
double f(double x) {
    return x * x; // Example function
}

int main() {
    pid_t pid;
    int x1 = 1, x2 = 10, n = 100;
    double size = 1024; // Size of shared memory segment
    int segment_id;
    char *shared_memory;

    // Initialize random number generator
    srand(time(NULL));

    // Create 5 child processes
    for (int k = 0; k < 5; k++) {
        // Fork a child process
        pid = fork();

        // Error occurred on fork
        if (pid < 0) {
            fprintf(stderr, "Fork Failed");
            return 1;
        }
        // This is what the child process will run
        else if (pid == 0) {
            // Create a shared memory segment
            segment_id = shmget(IPC_PRIVATE, size, S_IRUSR | S_IWUSR);

            // Attach the shared memory segment
            shared_memory = (char *)shmat(segment_id, NULL, 0);

            printf("This is child\n");

            double x = 0;
            double sum = 0;

            // Run process that sums the function
            for (int i = 0; i < n; i++) {
                // Get random number in range of x1-x2
                x = (double)rand() / RAND_MAX * (x2 - x1) + x1;
                sum = sum + f(x);
            }

            // Write output to the shared memory segment
            sprintf(shared_memory, "%f", sum);

            // Replacing the process image with `/bin/ls`
            execlp("/bin/ls", "ls", NULL);

            // If execlp fails
            fprintf(stderr, "execlp failed\n");
            exit(1);
        }
        // This is what the parent process will run
        else {
            // Wait for the child process to complete
            wait(NULL);

            // Attach the shared memory segment
            shared_memory = (char *)shmat(segment_id, NULL, 0);

            // Print output from shared memory
            printf("*%s\n", shared_memory);

            // Detach shared memory
            shmdt(shared_memory);

            // Remove the shared memory segment
            shmctl(segment_id, IPC_RMID, NULL);
        }
    } // End of for statement

    return 0;
}