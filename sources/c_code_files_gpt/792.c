#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc > 0) {
        size_t len = strlen(argv[0]) + 1;
        char *prog_name = (char *)malloc(len);
        if (prog_name != NULL) {
            strncpy(prog_name, argv[0], len);
            printf("Program name: %s\n", prog_name);
            free(prog_name);
        } else {
            fprintf(stderr, "Memory allocation failed\n");
        }
    }
    return 0;
}