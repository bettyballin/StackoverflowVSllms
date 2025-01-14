#include <stdio.h>
#include <proc/readproc.h>
#include <sys/types.h>
#include <dirent.h>
#include <unistd.h>

// Function to print open files for a process
void print_open_files(pid_t pid) {
    char path[256];
    snprintf(path, sizeof(path), "/proc/%d/fd", pid);
    DIR* dir = opendir(path);
    if (dir == NULL) {
        return;
    }

    struct dirent* entry;
    while ((entry = readdir(dir)) != NULL) {
        if (entry->d_type == DT_LNK) {
            char link_path[256];
            snprintf(link_path, sizeof(link_path), "/proc/%d/fd/%s", pid, entry->d_name);
            char file_path[256];
            ssize_t len = readlink(link_path, file_path, sizeof(file_path)-1);
            if (len != -1) {
                file_path[len] = '\0';
                printf("  FD: %s -> %s\n", entry->d_name, file_path);
            }
        }
    }

    closedir(dir);
}

int main() {
    PROCTAB* proc = openproc(PROC_FILLARG | PROC_FILLCOM | PROC_FILLSTAT);
    proc_t proc_info;

    while (readproc(proc, &proc_info) != NULL) {
        printf("PID: %d, Name: %s\n", proc_info.tid, proc_info.cmd);
        print_open_files(proc_info.tid);
    }

    closeproc(proc);
    return 0;
}