#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char *simFile = malloc(1024);
    strcpy(simFile, "path");
    // Don't forget to free the memory when you're done with it
    free(simFile);
    return 0;
}