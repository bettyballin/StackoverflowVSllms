#include <stdio.h>
#include <inttypes.h>

int main() {
    uint64_t num = 285212672; //FYI: fits in 29 bits
    int normalInt = 5;
    printf("My number is %zu bytes wide and its value is %" PRIu64 ". A normal number is %d.\n",
           sizeof(num), num, normalInt);
    return 0;
}