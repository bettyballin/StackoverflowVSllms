#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    pid_t childPid = fork();
    if (childPid == 0) {
        printf("Child process started.\n");
        sleep(60);
        return 234; // Child returns this exit code to parent.
    } else if (childPid > 0) {
        int status;
        pid_t check = waitpid(-1, &status, WNOHANG | WUNTRACED);
        while(check != -1) {
            if (WIFEXITED(status))
                printf("Child exited normally %d\n", WEXITSTATUS(status));
            else if (WIFSIGNALED(status))
                printf("Child terminated due to a signal: %d\n", WTERMSIG(status));
            else if (WIFSTOPPED(status)) {
                // To distinguish between zombie and stopped process.
                int childPid = waitpid(-1, &status, WCHLD | WUNTRACED);
                if (childPid > 0 && WEXITSTATUS(status) == 234)
                    printf("This is parent: Child zombie detected.\n");
            } else { // child didn't exit/terminate on signal yet, check next time.
                sleep(1);
                check = waitpid(-1, &status, WNOHANG | WUNTRACED);
                continue;
            }
            break;
        }
    } else {
        perror("fork error");
    }
    return 0;
}