#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <string.h>

int main() {
    int pid = fork(); // assuming you want to fork a child process

    if (pid == 0) {
        // child process
        // your child process code here
        exit(0); // or some other exit status
    } else if (pid > 0) {
        int wstatus;
        waitpid(pid, &wstatus, 0);  /* wait for child to finish */

        if (WIFEXITED(wstatus)) {
            printf("child terminated normally with exit code %d\n", WEXITSTATUS(wstatus));
        } else if (WIFSIGNALED(wstatus)) {   // in case the process got a signal, like SIGSEGV
            printf("Child was killed by signal number #%d (%s)\n", WTERMSIG(wstatus), strsignal(WTERMSIG(wstatus)));
        } else {
            /* abnormal termination such as WIFSIGNALED */
            printf("child died unclean death: %d\n", wstatus);  // just output the raw status if not recognized.
        }
    } else {
        // fork failed
        perror("fork");
        exit(1);
    }

    return 0;
}