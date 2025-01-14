#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>

#define BUFFER_LEN 1024
#define READ 0                   /* constants for pipe endpoints */
#define WRITE 1

// Function to read a line from a file descriptor
int readLine(int fd, char *buffer) {
    int n = 0;
    char c;
    while ((n < BUFFER_LEN - 1) && (read(fd, &c, 1) > 0) && (c != '\n')) {
        buffer[n++] = c;
    }
    if (n > 0) {
        buffer[n] = '\0';
        return 1;
    } else {
        return 0;
    }
}

int main() {
    char buffer[BUFFER_LEN];     /* where to hold our pipe's input */
    int pipes[2];                   /* stores two file descriptors */
    pid_t processID;                /* where we hold the return val of fork() */

    if (pipe(pipes) == -1)          /* call to system function pipe(), it creates a pipe */
    {                           /* note: using only one argument with pipe is ok since pipes[2] will store both file descriptors. */
        fprintf(stderr, "Pipe failed.\n");       /* error handling if unsuccessful. */
        return -1;
    }

    processID = fork();             /* call to system function fork(), it creates a new child process. Returns child's PID to parent and 0 to the child process itself, else returns -1 on failure */
    if (processID == -1)         /* error handling if unsuccessful forking */
    {
        fprintf(stderr, "Fork failed.\n");
        return -1;
    }

    if (processID > 0)            /* this is the parent process*/
    {
        close(pipes[WRITE]);   // Close write side in parent. You won't be writting to it. pipes[READ] remains open for reading whatever child writes into its end of Pipe through stdout which has been redirected
        while (readLine(pipes[READ], buffer)) {    /* read from pipe until EOF */
            printf("%s\n", buffer);      // Here you can do what you need with the outputs generated by the process. In this case print them to standard output
        }
    }
    else if (processID == 0)     /* this is the child process*/
    {
        close(pipes[READ]);    // Close read side in child as there won't be any reading here but only writting into. pipes[WRITE] remain open for writing whatever stdout prints to parent's end of Pipe which has been redirected to it
        dup2(pipes[WRITE], STDOUT_FILENO);   /* connect the write-side of pipe to child's standard output */
        execl("/path/to/executable", "/path/to/executable", (char *) NULL); /* replace this process with new one. If successful, execve() does not return; otherwise it returns -1 with errno set */
        // If execl fails, print an error message
        fprintf(stderr, "Exec failed: %s\n", strerror(errno));
        return -1;
    }

    return 0;
}