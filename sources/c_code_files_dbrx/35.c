#include <unistd.h> /* for sysconf(int) */
#define _GNU_SOURCE /* To get definition of struct psinfo, which is in the GNU C library header file sys/procfs.h. And also get pgid_t, pid_t  */
#include <linux/sched.h>    /* For constants ORIG_EUID etc */
#include <sys/types.h>  /* for pid_t */
#include <sys/sysctl.h> /* for sysctl */
#include <stdlib.h> /* for malloc */
#include <errno.h> /* for ENOMEM */

#define __USE_GNU

int findChildProcesses(int ** pids) {
    // Get the max PID limit from Linux Kernel, which is returned by sysconf(_SC_CHILD_MAX).
    long max_pid = (long)sysconf (_SC_PID_MAX);

    // allocate space for array of type pid_t to store all child process ids.
    int *childPids = malloc((max_pid+1)*sizeof(int));

    if (!childPids) {
        return -ENOMEM;
    }

    int pidsCount = 0 ;

    /* Here is the magic: walk through process id space */
    for (long pid = max_pid; pid >= 0; pid--) {
        // Get child info from proc filesystem.
        struct task_struct ts;
        ssize_t len = sysctl(CTL_KERN, KERN_PROC_ARGS, pid, sizeof(ts), &ts);
        if ((len > 0) && !!(ts.flags & CLONE_CHILD)) {
            /* This should only match true child processes */
            childPids[pidsCount++] = (int)pid;
        }

        // No need to search further, as no PIDs are more than sysconf (_SC_CHILD_MAX).
        if(pid <= 1) break;
    }

    *pids=childPids;
    return pidsCount ;
}

int main() {
    int *pids;
    int count = findChildProcesses(&pids);
    // Do something with pids and count
    free(pids);
    return 0;
}