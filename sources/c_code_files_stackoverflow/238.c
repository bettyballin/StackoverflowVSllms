#include <stdio.h>

int main() {
    int x = 1;
    int y = 2;
    int stride = 10;
    int* p = (int*) malloc(100 * sizeof(int)); // allocate some memory

    p[((y)*stride)+((x)*4)] = 5; // assign a value to the calculated index

    printf("%d\n", p[((y)*stride)+((x)*4)]); // print the value

    free(p); // free the allocated memory

    return 0;
}