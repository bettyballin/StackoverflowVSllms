#include <stdint.h>
#include <stdio.h>

int main() {
    void* param = NULL; // Define a pointer to pass as an argument
    intptr_t real_param = (intptr_t)param;

    printf("Value of real_param: %ld\n", real_param);

    return 0;
}