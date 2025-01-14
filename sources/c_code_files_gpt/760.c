#include <string.h>
#include <stdio.h> // For printf, in case you want to print error messages

int main() {
    char dst[10];
    char src[10] = "Hello";
    size_t dst_len = sizeof(dst);
    size_t in_len = sizeof(src);

    errno_t err = memcpy_s(dst, dst_len, src, in_len);
    if (err) {
        printf("Error occurred during memcpy_s: %d\n", err);
        // Handle error
    } else {
        printf("memcpy_s completed successfully.\n");
    }

    return 0;
}