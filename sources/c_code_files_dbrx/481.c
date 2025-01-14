#include <stdio.h>
#include <string.h>

int main() {
    // Sample source and destination arrays
    char source[] = "Hello, World!";
    char destination[20];

    // Sample sizes
    size_t sizeInBytes1 = sizeof(destination);
    size_t sizeInBytes2 = sizeof(source);

    errno_t result = memcpy_s(destination, sizeInBytes1, source, sizeInBytes2);
    if (result != 0) {
        printf("Error occurred: %d\n", result);
    } else {
        printf("Destination: %s\n", destination);
    }

    return 0;
}