#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_zombie(pid_t pid) {
    char path[40], buffer[1024];
    FILE *fp;
    snprintf(path, sizeof(path), "/proc/%d/stat", pid);

    if ((fp = fopen(path, "r")) == NULL) {
        perror("fopen");
        return -1;
    }

    if (fgets(buffer, sizeof(buffer), fp) == NULL) {
        perror("fgets");
        fclose(fp);
        return -1;
    }

    fclose(fp);

    char *token = strtok(buffer, " ");
    for (int i = 1; i <= 2; ++i) {
        token = strtok(NULL, " ");
    }

    if (token == NULL) {
        fprintf(stderr, "Error parsing stat file\n");
        return -1;
    }

    // The state is the third token in the stat file
    char state = token[0];

    // 'Z' indicates a zombie process
    return (state == 'Z') ? 1 : 0;
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <pid>\n", argv[0]);
        return 1;
    }

    pid_t pid = atoi(argv[1]);
    int result = is_zombie(pid);

    if (result == 1) {
        printf("Process %d is a zombie.\n", pid);
    } else if (result == 0) {
        printf("Process %d is not a zombie.\n", pid);
    } else {
        printf("Error determining the state of process %d.\n", pid);
    }

    return 0;
}