#include <stdio.h>

int main() {
    long sz = 1234567890; // Example value for sz
    char tmpret[128];

    snprintf(tmpret, 128, "%ld", sz);

    printf("%s\n", tmpret);

    return 0;
}