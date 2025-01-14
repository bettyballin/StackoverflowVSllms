#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

#define NUM_FILES 10

void process_file(int file_index, int write_pipe) {
    // Simulate processing with sleep
    for (int i = 0; i <= 100; i += 10) {
        sleep(1); // Simulate work
        write(write_pipe, &i, sizeof(i)); // Send progress to parent
    }
    close(write_pipe);
}

int main() {
    int pipes[NUM_FILES][2];
    pid_t pids[NUM_FILES];
    
    for (int i = 0; i < NUM_FILES; i++) {
        if (pipe(pipes[i]) == -1) {
            perror("pipe");
            exit(EXIT_FAILURE);
        }
        
        if ((pids[i] = fork()) == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        }
        
        if (pids[i] == 0) { // Child process
            close(pipes[i][0]); // Close read end
            process_file(i, pipes[i][1]);
            exit(0);
        } else { // Parent process
            close(pipes[i][1]); // Close write end
        }
    }

    // Parent process: monitor progress
    int progress[NUM_FILES] = {0};
    int status;
    for (int i = 0; i < NUM_FILES; i++) {
        while (waitpid(pids[i], &status, WNOHANG) == 0) {
            int child_progress;
            if (read(pipes[i][0], &child_progress, sizeof(child_progress)) > 0) {
                progress[i] = child_progress;
                printf("File %d: %d%% complete\n", i, progress[i]);
            }
        }
    }

    // Close all pipes
    for (int i = 0; i < NUM_FILES; i++) {
        close(pipes[i][0]);
    }

    printf("All files processed.\n");
    return 0;
}