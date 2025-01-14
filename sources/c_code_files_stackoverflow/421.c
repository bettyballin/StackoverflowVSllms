#include <stdio.h>

int main() {
    int arr[] = {3, 2, 5, 2, 1, 5, 3};
    int num = 0, i;

    for (i=0; i < 7; i++)
        num ^= arr[i];

    printf("%i\n", num);
    return 0;
}