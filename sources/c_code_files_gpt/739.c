#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <mqueue.h>

#define QUEUE_NAME "/my_queue"

// Cleanup function to be called on normal termination
void cleanup() {
    mq_unlink(QUEUE_NAME);
    printf("Message queue unlinked.\n");
}

// Watchdog process function
void start_watchdog(pid_t main_pid) {
    while (1) {
        if (kill(main_pid, 0) != 0) {
            // Main process has terminated
            mq_unlink(QUEUE_NAME);
            printf("Watchdog: Message queue unlinked.\n");
            exit(0);
        }
        sleep(1); // Check every second
    }
}

int main() {
    pid_t pid = fork();
    if (pid == 0) {
        // Child process: Watchdog
        start_watchdog(getppid());
    } else {
        // Parent process: Main program
        atexit(cleanup);
        
        // Create the message queue
        mqd_t mqd = mq_open(QUEUE_NAME, O_CREAT | O_RDWR, 0644, NULL);
        if (mqd == (mqd_t)-1) {
            perror("mq_open");
            exit(1);
        }
        printf("Message queue created.\n");

        // Main program logic here
        // ...

        // Simulate normal termination
        printf("Main program terminating normally.\n");
        exit(0);
    }
    return 0;
}