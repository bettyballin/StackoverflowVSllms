#include <stdio.h>
#include <sys/ptrace.h>
#include <sys/wait.h>
#include <linux/user.h> /* For constants ORIG_EAX etc */
#define SYS_write 4

int main() {
    pid_t child;
    long orig_eax, result;

    // Attach to the process, and get its pid
    child = fork();

    if (child == 0) {
        // Child process
        ptrace(PTRACE_TRACEME, 0, NULL, NULL);
        execl("/bin/ls", "ls", NULL);
    } else {
        // Parent process
        waitpid(child, 0, 0);
        printf("Attached to %d\n", child);

        // Wait until the process stops or exits on its own
        result = ptrace(PTRACE_PEEKUSER, /* Read data from tracee (the program that is followed) */
                         child,            /* The one to follow: child pid. Here assumed attached beforehand */
                         ORIG_EAX,         /* What offset of this region of the process' memory */
                         0);               /* How far into its memory space */
        printf("Peek value is %ld\n", result); // Read and print the value of eax (return value)
    }

    return 0;
}