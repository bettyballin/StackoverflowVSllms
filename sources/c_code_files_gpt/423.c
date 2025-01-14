#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int pid, fd[2];
    int n;
    char line[20];
    
    if (pipe(fd) < 0) {
        printf("Error creating pipe");
    } else {
        pid = fork();
        
        if (pid < 0) {
            printf("Error while forking");
        } else {
            if (pid > 0) { // Parent process
                close(fd[0]); // Close reading end of the pipe
                write(fd[1], "Hello\n", 6); // Write to the pipe
                close(fd[1]); // Close writing end of the pipe
                while (wait(NULL) != pid); // Wait for the child process to finish
            } else { // Child process
                close(fd[1]); // Close writing end of the pipe
                n = read(fd[0], line, 20); // Read from the pipe
                
                if (n < 0) {
                    printf("Error reading a file");
                }
                
                write(1, line, n); // Write to standard output
                close(fd[0]); // Close reading end of the pipe
            }
        }
    }
    
    return 0;
}