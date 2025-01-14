#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <dlfcn.h>
#include <unistd.h>
#include <string.h>
#include <time.h>
#include <sys/types.h>

// Original write function pointer
ssize_t (*original_write)(int fd, const void *buf, size_t count);

ssize_t write(int fd, const void *buf, size_t count) {
    // Get the process name
    char proc_name[256];
    snprintf(proc_name, sizeof(proc_name), "/proc/%d/comm", getpid());
    FILE *f = fopen(proc_name, "r");
    if (!f) return -1;
    fgets(proc_name, sizeof(proc_name), f);
    fclose(f);
    proc_name[strcspn(proc_name, "\n")] = 0; // Remove newline

    // Get the current timestamp
    time_t t = time(NULL);
    struct tm *tm_info = localtime(&t);
    char time_str[26];
    strftime(time_str, 26, "%Y-%m-%d %H:%M:%S", tm_info);

    // Create the prefix
    char prefix[512];
    snprintf(prefix, sizeof(prefix), "[%s %d %s] ", proc_name, getpid(), time_str);

    // Create the new buffer with the prefix
    char new_buf[1024];
    snprintf(new_buf, sizeof(new_buf), "%s%.*s", prefix, (int)count, (char *)buf);

    // Call the original write function
    if (!original_write) {
        original_write = dlsym(RTLD_NEXT, "write");
    }
    return original_write(fd, new_buf, strlen(new_buf));
}

int main() {
    printf("Hello, World!\n");
    return 0;
}