#include <stdio.h>

int main(int argc, char *argv[]) {
    if (argc > 1) {
        printf("Argument 1 is %s\n", argv[1]);
    } else {
        printf("No arguments provided.\n");
    }
    return 0;
}