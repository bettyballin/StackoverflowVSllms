#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp;
    char buffer[128];

    // Read OS information
    fp = popen("uname -a", "r");
    if (fp == NULL) {
        perror("popen failed");
        exit(EXIT_FAILURE);
    }
    while (fgets(buffer, sizeof(buffer), fp) != NULL) {
        printf("Operating System: %s", buffer);
    }
    pclose(fp);

    // Read CPU information
    fp = fopen("/proc/cpuinfo", "r");
    if (fp == NULL) {
        perror("fopen failed");
        exit(EXIT_FAILURE);
    }
    while (fgets(buffer, sizeof(buffer), fp) != NULL) {
        printf("%s", buffer);
    }
    fclose(fp);

    return 0;
}