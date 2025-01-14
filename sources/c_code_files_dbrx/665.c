#include <stdio.h>
#include <stdlib.h>

int main() {
    char *filename = "/var/tmp/\"my file.pdf\"";
    if (remove(filename) != 0)
        printf("Error deleting file\n");
    return 0;
}