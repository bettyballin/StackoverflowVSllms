#include <dirent.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

/**
 * Recursively lists all child processes of a given parent process.
 *
 * @param ppid The parent process ID.
 */
void list_children(pid_t ppid) {
    DIR *dp = opendir("/proc");
    if (dp == NULL) {
        perror("opendir");
        return;
    }

    struct dirent *entry;
    while ((entry = readdir(dp)) != NULL) {
        if (entry->d_type == DT_DIR) {
            pid_t pid = atoi(entry->d_name);
            if (pid > 0) {
                char path[256];
                snprintf(path, sizeof(path), "/proc/%d/stat", pid);
                FILE *fp = fopen(path, "r");
                if (fp) {
                    pid_t parent_pid;
                    fscanf(fp, "%*d %*s %*c %d", &parent_pid);
                    fclose(fp);
                    if (parent_pid == ppid) {
                        printf("Child process: %d\n", pid);
                        list_children(pid);  // Recursive call to find grandchildren
                    }
                } else {
                    // Handle fopen error
                    perror("fopen");
                }
            }
        }
    }
    closedir(dp);
}

int main() {
    pid_t parent_pid = getpid();  // Replace with the PID you want to track
    printf("Tracking parent process: %d\n", parent_pid);
    list_children(parent_pid);
    return 0;
}