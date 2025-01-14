#include <stdio.h>
#include <stdlib.h>

int main() {
    if (remove("/var/tmp/\"my file.pdf\"") != 0) {
        printf("Error deleting file\n");
    }
    return 0;
}