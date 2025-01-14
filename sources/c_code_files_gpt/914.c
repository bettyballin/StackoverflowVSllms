#include <stdio.h>
#include <stdlib.h>

int main() {
    if (remove("/var/tmp/my file.pdf") != 0)
        perror("Error deleting file");
    else
        printf("File successfully deleted\n");

    return 0;
}