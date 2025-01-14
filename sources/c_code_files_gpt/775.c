#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {
    char prog_name[128];
    if (argc > 0) {
        strncpy(prog_name, argv[0], sizeof(prog_name) - 1);
        prog_name[sizeof(prog_name) - 1] = '\0'; // Ensure null-termination
    }
    printf("Program name: %s\n", prog_name);
    return 0;
}