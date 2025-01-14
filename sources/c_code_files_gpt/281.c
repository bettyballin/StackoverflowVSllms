#include <stdio.h>
#include <stdlib.h>
#include <libproc.h>
#include <errno.h>
#include <string.h>
#include <fcntl.h> // Add this for open() function
#include <sys/ioctl.h> // Add this for ioctl() function

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <pid>\n", argv[0]);
        return 1;
    }

    pid_t pid = atoi(argv[1]);
    char proc_path[64];
    snprintf(proc_path, sizeof(proc_path), "/proc/%d", pid);

    prpsinfo_t psinfo;
    int fd = open(proc_path, O_RDONLY);
    if (fd == -1) {
        perror("Failed to open process file");
        return 1;
    }

    if (ioctl(fd, PIOCPSINFO, &psinfo) == -1) {
        perror("Failed to get process info");
        close(fd);
        return 1;
    }

    close(fd);

    printf("Process ID: %d\n", psinfo.pr_pid);
    printf("Process Name: %s\n", psinfo.pr_fname);
    printf("User ID: %d\n", psinfo.pr_uid);
    printf("Group ID: %d\n", psinfo.pr_gid);
    printf("Number of Threads: %d\n", psinfo.pr_nlwp);
    printf("CPU Time: %ld.%ld\n", psinfo.pr_time.tv_sec, psinfo.pr_time.tv_nsec);

    return 0;
}