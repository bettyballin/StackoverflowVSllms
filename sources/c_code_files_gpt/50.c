#include <stdio.h>
#include <proc/readproc.h>

int main() {
    PROCTAB* proc = openproc(PROC_FILLARG | PROC_FILLCOM | PROC_FILLSTAT);
    proc_t proc_info;

    while (readproc(proc, &proc_info) != NULL) {
        printf("PID: %d, Name: %s\n", proc_info.tid, proc_info.cmd);
    }

    closeproc(proc);
    return 0;
}