#include <sys/ptrace.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/syscall.h>
#include <stdio.h>

int main() {
    pid_t child;
    long orig_rax;
    child = fork();
    if(child == 0) {
        ptrace(PTRACE_TRACEME, 0, NULL, 0);
        execl("/bin/ls", "ls", (char*) NULL);
    } else {
        wait(NULL);
        while(1) {
            ptrace(PTRACE_SYSCALL, child, NULL, 0);
            wait(NULL);
            orig_rax = ptrace(PTRACE_PEEKUSER, child, 8 * ORIG_RAX, NULL);
            printf("Syscall: %ld\n", orig_rax);
            if(orig_rax == SYS_exit || orig_rax == SYS_exit_group)
                break;
            ptrace(PTRACE_SYSCALL, child, NULL, 0);
            wait(NULL);
        }
    }
    return 0;
}