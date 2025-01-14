#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h> // Added for wait() function

void create_children(int level, int max_level) {
    if (level >= max_level) return;

    pid_t child1_pid = fork();
    if (child1_pid == 0) {
        // We are in child1 process
        printf("This is child level %d, with PID %d\n", level + 1, (int)getpid());
        if (level + 1 == 2 || level + 1 == 4) {
            create_children(level + 1, max_level);
        }
        return;
    }

    pid_t child2_pid = fork();
    if (child2_pid == 0) {
        // We are in child2 process
        printf("This is child level %d, with PID %d\n", level + 1, (int)getpid());
        if (level + 1 == 2 || level + 1 == 4) {
            create_children(level + 1, max_level);
        }
        return;
    }

    // Wait for children to finish
    wait(NULL);
    wait(NULL);
}

int main() {
    printf("This is the parent process, with PID %d\n", (int)getpid());
    create_children(0, 5);
    return 0;
}