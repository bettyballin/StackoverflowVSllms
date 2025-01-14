#include <stdio.h>
#include <dirent.h>
#include <string.h>
#include <errno.h> // Added for errno variable

int find_pid(const char *process_name) {
    DIR *procfs = opendir("/proc");
    struct dirent *de; // Directory entry for the loop.
    if (procfs == NULL) {
        perror("Unable to open /proc directory.");
        return -1;
    }

    while ((de = readdir(procfs)) != NULL) {
        int pid, n;
        // Get the PID from the filename. Ignore "." and ".." directories.
        if (sscanf(de->d_name, "%i", &pid) == 1 && de->d_name[0] != '.') {
            char cmdline[256]; // Buffer for reading /proc/<pid>/cmdline file.
            snprintf(cmdline, sizeof cmdline, "/proc/%i/cmdline", pid);
            FILE *fp = fopen(cmdline, "r");
            if (fp != NULL) {
                n = fread(cmdline, sizeof(char), sizeof cmdline - 1, fp);
                // Replace first null byte with terminating one in case the process name contains spaces.
                for (int i = 0; i < n; ++i) {
                    if (cmdline[i] == '\0') {
                        cmdline[i] = ' ';
                    }
                }
                // Add null byte at end of string in case line does not contain one.
                cmdline[sizeof(cmdline) - 1] = '\0';
                if (strstr(cmdline, process_name) != NULL) {
                    fclose(fp);
                    closedir(procfs);
                    return pid;
                }
                fclose(fp); // Added to close file pointer
            } // If file could not be opened or the program name does not match.
            else {
                if (errno != ENOENT) {
                    perror("Error reading /proc/<pid>/cmdline.");
                    closedir(procfs);
                    return -1; // Error occurred.
                }
            }
        }
    }
    fprintf(stderr, "Unable to find process %s.\n", process_name); // Added newline character
    closedir(procfs);
    return -1; // Not found error.
}

int main() {
    const char *process_name = "example_process"; // Replace with your process name
    int pid = find_pid(process_name);
    if (pid != -1) {
        printf("Found process %s with PID %d\n", process_name, pid);
    }
    return 0;
}