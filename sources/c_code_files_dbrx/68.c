#include <stdio.h>

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    printf("%d\n", 2[arr]); // prints "3" because it is equivalent to *(arr+2) or arr[2].
    return 0;
}