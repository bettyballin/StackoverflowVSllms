#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

pid_t id_process;

void manager_signal(int signum) {
    kill(id_process, SIGKILL);
    kill(getppid(), SIGKILL);
}

int main() {
    id_process = fork();
    if (id_process == -1) {
        perror("ERROR to create the fork");
        exit(EXIT_FAILURE);
    } else {
        if (id_process != 0) { // Parent process
            printf("Father's ID is %d\n", getpid());
            alarm(5);
            signal(SIGALRM, manager_signal);
            sleep(20);
            printf("Running to where the father can be\n");
            alarm(0); 
        } else { // Child process
            printf("Children's ID is %d\n", getpid());
            for (;;) {
                printf("Children RUN FOREVER ^^ \n");
                sleep(2);
            }
        }
    }
    return 0;
}