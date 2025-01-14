#include <stdio.h>

int main() {
    int array1[2] = {1, 2};
    int array2[2] = {3, 4};

    int (*data[2])[2] = {&array1, &array2};

    // Accessing the elements
    printf("%d\n", (*data[0])[0]); // prints 1
    printf("%d\n", (*data[0])[1]); // prints 2
    printf("%d\n", (*data[1])[0]); // prints 3
    printf("%d\n", (*data[1])[1]); // prints 4

    return 0;
}