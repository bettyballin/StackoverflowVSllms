#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ptrace.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/user.h>
#include <errno.h>

void find_child_processes(pid_t parent_pid) {
    pid_t pid;
    int status;

    // Attach to the parent process
    if (ptrace(PTRACE_ATTACH, parent_pid, NULL, NULL) == -1) {
        perror("ptrace(PTRACE_ATTACH)");
        exit(EXIT_FAILURE);
    }

    // Wait for the parent process to stop
    waitpid(parent_pid, &status, 0);

    // Set options to trace children
    if (ptrace(PTRACE_SETOPTIONS, parent_pid, NULL, PTRACE_O_TRACEFORK | PTRACE_O_TRACEVFORK | PTRACE_O_TRACECLONE) == -1) {
        perror("ptrace(PTRACE_SETOPTIONS)");
        exit(EXIT_FAILURE);
    }

    while (1) {
        pid = waitpid(-1, &status, __WALL);

        if (pid == -1) {
            if (errno == ECHILD) {
                break;
            } else {
                perror("waitpid");
                exit(EXIT_FAILURE);
            }
        }

        if (WIFSTOPPED(status)) {
            if (status >> 8 == (SIGTRAP | (PTRACE_EVENT_FORK << 8)) ||
                status >> 8 == (SIGTRAP | (PTRACE_EVENT_VFORK << 8)) ||
                status >> 8 == (SIGTRAP | (PTRACE_EVENT_CLONE << 8))) {
                
                // Get the new child process ID
                unsigned long new_pid;
                if (ptrace(PTRACE_GETEVENTMSG, pid, NULL, &new_pid) == -1) {
                    perror("ptrace(PTRACE_GETEVENTMSG)");
                    exit(EXIT_FAILURE);
                }

                printf("New child process: %lu\n", new_pid);

                // Continue the child process
                if (ptrace(PTRACE_CONT, new_pid, NULL, NULL) == -1) {
                    perror("ptrace(PTRACE_CONT)");
                    exit(EXIT_FAILURE);
                }
            }

            // Continue the traced process
            if (ptrace(PTRACE_CONT, pid, NULL, NULL) == -1) {
                perror("ptrace(PTRACE_CONT)");
                exit(EXIT_FAILURE);
            }
        }
    }

    // Detach from the parent process
    if (ptrace(PTRACE_DETACH, parent_pid, NULL, NULL) == -1) {
        perror("ptrace(PTRACE_DETACH)");
        exit(EXIT_FAILURE);
    }
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <parent_pid>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    pid_t parent_pid = atoi(argv[1]);
    find_child_processes(parent_pid);

    return 0;
}