#include <unistd.h>
#include <sys/syscall.h>
#include <linux/auxvec.h>
#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/types.h>
#include <dirent.h>
#include <unistd.h>
#include <linux/limits.h>

static void list_process_files(pid_t pid) {
    char filename[1024]; // should be enough for full file paths
    snprintf(filename, sizeof(filename), "/proc/%ld/fd", (long)pid);
    DIR *dir = opendir(filename);
    if (!dir) return;

    struct dirent *ent;
    while ((ent = readdir(dir))) {
        char fname[8192]; // should be enough for full file paths
        char linkname[1024];
        ssize_t linksize;
        snprintf(fname, sizeof(fname), "/proc/%ld/fd/%s", (long)pid, ent->d_name);
        linksize = readlink(fname, linkname, sizeof(linkname));
        if (linksize != -1) {
            linkname[linksize] = '\0';
            printf("/proc/%ld/fd/%s -> %s\n", (long)pid, ent->d_name, linkname);
        }
    }
    closedir(dir);
}

int main() {
    pid_t pid = getpid(); // replace with desired process ID
    list_process_files(pid);

    return 0;
}