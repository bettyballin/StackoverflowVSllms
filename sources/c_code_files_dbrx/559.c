#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <sys/wait.h>

#define SIZE_OF_ROW 1000000

// Function to count occurrences of a number in a row
int count_occurrence(int row[], int size, int specific_number) {
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (row[i] == specific_number) {
            count++;
        }
    }
    return count;
}

int main() {
    int pipe_fds[2];      /* the file descriptors for this end of the pipe */
    pid_t childpid;       /* process id for child process */
    char *endptr = NULL;  // used by strtol, contains parsed integer or error message.
    static const int BUFFER_SIZE = 2048;
    static const int PIPEFD_READ = 0;
    static const int PIPEFD_WRITE = 1;
    char buf[BUFFER_SIZE]; /* buffer to read output from child */
    int i, num_instances = 0;   // counts occurences of a number per row.
    int fd_pipes[(int)pow(26,10)] = {0};
    int specific_number = 0; // Define the specific number to count occurrences of

    if (pipe(pipe_fds) == -1) /* create pipe */ {
        perror("Failed creating pipe");
        exit(EXIT_FAILURE);
    }

    childpid = fork();                //fork call to create new process.
    if (-1 == childpid)               /* Fork error? We have no children */
       perror ("No Child!");   exit (EXIT_FAILURE);

    else if(childpid){         /* we are parent */
        close(pipe_fds[PIPEFD_WRITE]); // Close the writing end of the pipe
        read(pipe_fds[PIPEFD_READ], buf, BUFFER_SIZE - 1);
        num_instances += strtol(buf, &endptr, 10);
        // write logic to check for end of rows and print sum if finished
        waitpid(-1, NULL, 0);     //Wait for any child process finish using `waitpid()`.
        close(pipe_fds[PIPEFD_READ]); // Close the reading end of the pipe
   } else {             /* we are child */
        close(pipe_fds[PIPEFD_READ]); // Close the reading end of the pipe
        int row[SIZE_OF_ROW];  /* array of specific size to store row data. */
        // read the numbers from input/file into this new variable(row[])
        for (i = 0; i < SIZE_OF_ROW; i++) {
            row[i] = rand() % 100; // Fill the row with random numbers
        }
        num_instances = count_occurrence(row, SIZE_OF_ROW, specific_number);
        sprintf(buf,"%d",num_instances);  //Convert the number of occurences to a char array which then is sent back to parent process using write.
        write(pipe_fds[PIPEFD_WRITE], buf, strlen(buf));
        close(pipe_fds[PIPEFD_WRITE]); // Close the writing end of the pipe
   }
    return EXIT_SUCCESS;         /* child exits */
}