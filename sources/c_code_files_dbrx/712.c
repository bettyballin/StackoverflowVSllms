#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>

pid_t id_process;

void manager_signal(int signo) {
     kill(id_process, SIGKILL);
     kill(-getppid(), SIGKILL);
}

int main() {
    id_process = fork();
    if (id_process == -1) {
        perror("ERROR to create the fork");
    } else {
         if (id_process != 0) {
             printf("Father's ID is %d\n", getpid());
             alarm(5);
             (void) signal(SIGALRM, manager_signal);
             sleep(20);
             printf("Father running to where he can be\n");
             alarm(0);
         } else {
             printf("Child's ID is %d\n", getpid());
             while(1) {
                 printf("Child running forever ^^\n");
                 sleep(2);
             }
         }
    }
     return 0;
}