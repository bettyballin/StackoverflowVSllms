#include <sys/ptrace.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/user.h> // Include this header for struct user_regs_struct

void trace_process(pid_t pid) {
    int status;
    while (1) {
        waitpid(pid, &status, 0);
        if (WIFEXITED(status))
            break;
        if (WIFSTOPPED(status) && WSTOPSIG(status) == SIGTRAP) {
            // A new child has been forked
            struct user_regs_struct regs;
            ptrace(PTRACE_GETREGS, pid, NULL, &regs);
            pid_t new_child_pid = regs.rdi;  // On x86_64, the child PID is in RDI
            printf("New child process with PID: %d\n", new_child_pid);
        }
        ptrace(PTRACE_SYSCALL, pid, NULL, NULL);
    }
}

int main(int argc, char* argv[]) {
    pid_t pid = fork();
    if (pid == 0) {
        // Child process
        ptrace(PTRACE_TRACEME, 0, NULL, NULL);
        execl("/path/to/your/program", "your_program", NULL);
    } else {
        // Parent process
        trace_process(pid);
    }
    return 0;
}