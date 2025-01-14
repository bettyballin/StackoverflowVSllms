#include <sys/ptrace.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/user.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>

int main(int argc, char *argv[]) {
    pid_t child;
    if ((child = fork()) == 0) {
        ptrace(PTRACE_TRACEME, 0, NULL, NULL);
        execl(argv[1], argv[1], NULL);
    } else {
        int status;
        while (1) {
            wait(&status);
            if (WIFEXITED(status)) break;
            struct user_regs_struct regs;
            ptrace(PTRACE_GETREGS, child, NULL, &regs);
            // Intercept and modify socket system calls here
            ptrace(PTRACE_SYSCALL, child, NULL, NULL);
        }
    }
    return 0;
}