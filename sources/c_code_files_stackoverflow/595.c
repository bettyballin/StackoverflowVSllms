#include <stdio.h>

void arryprnt(int* a, char* intro, int len, char* sep, char* end) {
    printf("%s", intro);
    for (int i = 0; i < len; i++) {
        printf("%d", a[i]);
        if (i < len - 1) {
            printf("%s", sep);
        }
    }
    printf("%s", end);
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    arryprnt(arr, "Array: ", 5, ", ", ".");
    return 0;
}