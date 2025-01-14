#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

int main() {
    pid_t pid;
    char *pArgs[] = {"ls", "-l", NULL}; // replace with your own commands

    pid = fork();

    if(pid == 0) { // child process code goes here...
        int ret_val = execvp(pArgs[0], pArgs);
        if (ret_val < 0) {
            perror("exec");
            _exit(-1);     // terminate with exit status -1 and error message from errno
        }   else {
            _exit(0);   // successful termination, no error
        }
    } else if (pid > 0) { // parent process code goes here...
        wait(NULL); // wait for child process to finish
    } else { // fork failed
        perror("fork");
        exit(1);
    }

    return 0;
}