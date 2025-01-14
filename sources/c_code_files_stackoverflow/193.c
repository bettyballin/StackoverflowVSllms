#include <stdlib.h>

char *test() {
    char* arr = malloc(100);
    arr[0] = 'M';
    return arr;
}

int main() {
    char *str = test();
    // You may want to add error checking for malloc failure here
    free(str);
    return 0;
}