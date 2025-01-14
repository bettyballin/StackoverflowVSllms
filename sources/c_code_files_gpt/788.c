#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp;
    char path[1035];

    // Open the command for reading
    fp = popen("echo '1 2 3 4 5' | awk '{print $3}'", "r");
    if (fp == NULL) {
        printf("Failed to run command\n");
        exit(1);
    }

    // Read the output a line at a time and print to stdout
    while (fgets(path, sizeof(path), fp) != NULL) {
        printf("%s", path);
    }

    // Close the file pointer
    pclose(fp);

    return 0;
}