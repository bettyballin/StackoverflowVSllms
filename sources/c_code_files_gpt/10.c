#include <sys/prctl.h>
#include <signal.h>
#include <stdlib.h>
#include <unistd.h>

void handle_signal(int sig) {
    if (sig == SIGHUP) {
        // Handle the signal appropriately, for example, by exiting
        exit(0);
    }
}

int main() {
    pid_t pid = fork();

    if (pid == -1) {
        // Fork failed
        return 1;
    } else if (pid == 0) {
        // This is the child process
        signal(SIGHUP, handle_signal); // Set up signal handler
        pause(); // Wait for signal
    } else {
        // This is the parent process
        prctl(PR_SET_PDEATHSIG, SIGHUP); // Send SIGHUP to child if parent exits
        // Parent process code
        sleep(10); // Simulate parent process work
    }

    return 0;
}