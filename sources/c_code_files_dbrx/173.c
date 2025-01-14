#include <string.h>
#include <stdio.h>

int main() {
    char dst[5] = "";
    char src[] = "Hello, World!"; // Size 13 including the null terminator

    if (memcpy_s(dst, sizeof(dst), src, sizeof(src))) // Copying more than available space
        printf("Error in memcpy_s\nThe source size is %zu and destination buffer has a capacity of %zu.\n", sizeof(src), sizeof(dst));

    // The memcpy function does not return a value that indicates an error, 
    // so we cannot use its return value to check for errors.
    // Instead, we should ensure that the destination buffer is large enough 
    // to hold the data being copied.
    memcpy(dst, src, sizeof(dst) - 1); // Prevent buffer overflow
    dst[sizeof(dst) - 1] = '\0'; // Ensure null-termination

    printf("Returned from memcpy\n");

    return 0;
}