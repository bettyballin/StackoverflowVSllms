#include <unistd.h>     //for fork() and execv() functions
#include <stdio.h>      //for perror() function
#include <stdlib.h>     //for exit() function

int main() {
    pid_t pid;
    /* Create the child process */
    if ((pid = fork()) == -1) {
        perror("fork");           /* Check for error conditions  */
        exit(1);                         /* If we couldn't create.. exit    */
    } else if (pid != 0) {          /* This is the parent process   */
        //... execute parent code if any
        return 0; //Parent process ends here so that child process runs uninterrupted.
    } else {     /* Here we can do execve or _wsystem() etc to run the command and not wait for browser to exit*/
        char *argv[] = {/*command as array of char pointers, remember to add NULL at end */};
        execv("/path/to/your/program", argv); //replace /path/to/your/program with your command. This launches the process and returns control back immediately.
        perror("execv"); // If execv fails, print error message
        exit(1); // If execv fails, exit with non-zero status
    }
}