#include <stdio.h>
#include <stdlib.h>

int main() {
    if (remove("/var/tmp/my file.pdf") != 0) {
        perror("Error removing file");
        return EXIT_FAILURE;
    }
    return EXIT_SUCCESS;
}