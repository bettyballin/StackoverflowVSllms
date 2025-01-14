#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid;

    pid = fork();
    if(pid > 0) {
        // Inside process 0
        printf("Process 0: %d\n", getpid());

        pid = fork();
        if(pid > 0) {
            // still in process 0
            printf("Still in Process 0: %d\n", getpid());
        } else if(pid == 0) {
            // in process 2
            printf("Process 2: %d\n", getpid());

            pid = fork();
            if(pid > 0) {
                // still in process 2
                printf("Still in Process 2: %d\n", getpid());
            } else if(pid == 0) {
                // in process 3
                printf("Process 3: %d\n", getpid());
            } else {
                // fork failed
                perror("fork");
            }
        } else {
            // fork failed
            perror("fork");
        }
    } else if(pid == 0) {
        // Inside process 1
        printf("Process 1: %d\n", getpid());
    } else {
        // fork failed
        perror("fork");
    }

    return 0;
}