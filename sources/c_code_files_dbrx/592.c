#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

int main(void) {
    int fd[2]; // file descriptor for the pipe
    pid_t pid;  // Process ID to store fork()'s return value

    if (pipe(fd) == -1) {
        fprintf(stderr, "Error creating a pipe\n");
        exit(-1);
    }

    pid = fork(); // Creates child process and returns its PID in parent process & 0 in the child

    if (pid < 0) { // error occurred
        fprintf(stderr, "Can't fork!\n");
        return -1;
    } else if (pid > 0) { // parent process
        int status;
        waitpid(pid, &status, 0); // Wait for child to finish before going on executing the rest code. It also prevents zombie processes

        char buffer[256]; // To store command output
        close(fd[1]);  // Close write
        read(fd[0], buffer, sizeof(buffer));
        printf("Command Output : %s\n", buffer);
    } else { // child process (pid == 0)
        dup2(fd[1], STDOUT_FILENO); // Redirect standard output to pipe write end so all cout of the command will go into it.
        close(fd[1]); // Close pipes, we won't use them again since they are now stdout and stdin respectively

        // Replace "your-command" and its arguments with the actual command and arguments you want to execute
        execlp("ls", "ls", "-l", NULL); // execute new command by replacing the child with it.
        /* if you want to replace execvp instead of execlp: */
        // char *args[] = {"ls", "-l", NULL}; // Make sure the last argument is a null address!
        // execute command with its arguments.
        // execvp("ls", args);
    }
    return 0;
}