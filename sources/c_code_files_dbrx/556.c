#include <stdio.h>
#include <string.h>

int main() {
    char source[] = "Hello, World!";
    char destination[20];

    int len = sizeof(destination);
    strncpy(destination, source, len - 1);
    destination[len - 1] = '\0'; // Null terminate the destination

    printf("%s\n", destination);

    return 0;
}