#define __STDC_WANT_LIB_EXT1__ 1
#include <string.h>
#include <errno.h>
#include <stdio.h>

int main() {
    char src[10] = "123456789";
    char dest[10];

    errno_t status = memcpy_s(dest, sizeof(dest), src, strlen(src) + 1);
    if (status != 0) {
        printf("Error copying memory: %d\n", status);
        return -1;
    }

    printf("Copied string: %s\n", dest);
    return 0;
}