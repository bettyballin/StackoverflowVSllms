#include <stdio.h>
#include <string.h>

void copy_data(void* dst, size_t dst_len, void* src, size_t in_len) {
    if (in_len > dst_len) {
        fprintf(stderr, "Error: Input length exceeds destination length\n");
        return;
    }
    memcpy(dst, src, in_len);
}

int main() {
    char src[] = "Hello, World!";
    char dst[20];
    size_t src_len = strlen(src) + 1; // include null terminator
    size_t dst_len = sizeof(dst);

    copy_data(dst, dst_len, src, src_len);
    printf("%s\n", dst);

    return 0;
}