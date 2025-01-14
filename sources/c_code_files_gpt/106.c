#include <stdio.h>
#include <dirent.h>
#include <string.h>
#include <stdlib.h>

int find_pid_by_name(const char *process_name) {
    DIR *dir;
    struct dirent *entry;
    char path[256];
    char buffer[256];
    FILE *fp;
    int pid = -1;

    if (!(dir = opendir("/proc"))) {
        perror("opendir(/proc)");
        return -1;
    }

    while ((entry = readdir(dir)) != NULL) {
        if (entry->d_type == DT_DIR) {
            int id = atoi(entry->d_name);
            if (id > 0) {
                snprintf(path, sizeof(path), "/proc/%d/comm", id);
                if ((fp = fopen(path, "r")) != NULL) {
                    if (fgets(buffer, sizeof(buffer), fp) != NULL) {
                        strtok(buffer, "\n"); // Remove the newline character
                        if (strcmp(buffer, process_name) == 0) {
                            pid = id;
                            fclose(fp);
                            break;
                        }
                    }
                    fclose(fp);
                }
            }
        }
    }

    closedir(dir);
    return pid;
}

int main() {
    const char *process_name = "your_process_name";
    int pid = find_pid_by_name(process_name);

    if (pid > 0) {
        printf("PID of %s is %d\n", process_name, pid);
    } else {
        printf("Process %s not found\n", process_name);
    }

    return 0;
}