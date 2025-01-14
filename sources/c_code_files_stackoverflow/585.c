#include <stdio.h>
#include <stdlib.h>

typedef int dimensions[3][4];

int main() {
    dimensions *dim = (dimensions *)malloc(10 * sizeof(dimensions));
    dim[0][0][0] = 42;  // Assigning 42 to the first element
    printf("%d\n", dim[0][0][0]);  // Printing the value
    free(dim);
    return 0;
}