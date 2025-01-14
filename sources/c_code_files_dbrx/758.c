#include <stdio.h>

static void logooff() {
    /* Function implementation here */
    printf("logooff function called\n");
}

static void anotherFunctionNameCausingConflict() {
    /* Function implementation here */
    printf("anotherFunctionNameCausingConflict function called\n");
}

int main() {
    logooff();
    anotherFunctionNameCausingConflict();
    return 0;
}