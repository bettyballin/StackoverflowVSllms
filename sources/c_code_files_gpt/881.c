#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main() {
    pid_t pid;

    // Create a new session and make the calling process the session leader
    if ((pid = fork()) == 0) {
        // Child process
        if (setsid() < 0) {
            perror("setsid");
            exit(EXIT_FAILURE);
        }
        
        // Fork again to prevent the child from acquiring a controlling terminal
        if ((pid = fork()) == 0) {
            // Grandchild process
            // Perform exec* or other operations here
        } else if (pid > 0) {
            exit(EXIT_SUCCESS); // First child exits
        } else {
            perror("fork");
            exit(EXIT_FAILURE);
        }
    } else if (pid > 0) {
        // Parent process
        wait(NULL); // Wait for the first child to exit
    } else {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    return 0;
}