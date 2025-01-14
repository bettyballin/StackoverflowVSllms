#include <unistd.h> // fork, execv, getpid, sleep
#include <stdlib.h> // exit
#include <signal.h> // kill
#include <stdio.h>  // system

void reload() {
    pid_t parentPid = getpid();
    pid_t childPid;   // First Level Forking
    if ((childPid = fork()) == 0) {
        setsid();              // Create a new session and group.
        system("/etc/init.d/foo restart");
        exit(EXIT_SUCCESS);    // Exit child process explicitly
     } else {
         sleep(1);             // Wait for the system command to start.
         kill(parentPid, SIGTERM);  // Signal parent (which is foo), in this case to restart itself
     }
}

int main() {
    reload();
    return 0;
}