#include <stdio.h>

typedef int Int32;

int main() {
    Int32 status;

    #pragma GCC diagnostic push
    #pragma GCC diagnostic ignored "-Wformat"
    printf("status: %x", status);
    #pragma GCC diagnostic pop

    return 0;
}