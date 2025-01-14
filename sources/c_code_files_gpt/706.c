#include <stdio.h>
#include <stdlib.h>

int * ret_array(int n) {
    int * arr = (int *) malloc(10 * sizeof(int));
    if (arr == NULL) {
        perror("malloc failed");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < n; i++) {
        arr[i] = i * 2;
    }
    printf("Address pointer in ret_array: %p\n", (void *) arr);
    return arr;
}

int * ret_oth_array(int n) {
    int * arr = (int *) malloc(10 * sizeof(int));
    if (arr == NULL) {
        perror("malloc failed");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < n; i++) {
        arr[i] = i + n;
    }
    printf("Address pointer in ret_oth_array: %p\n", (void *) arr);
    return arr;
}

int main(void) {
    int *p = ret_array(5);
    int *x = ret_oth_array(6);

    printf("Address contained in p: %p\nValue of *p: %d\n", (void *) p, *p);

    free(x);
    x = NULL;  // Avoid dangling pointer
    free(p);
    p = NULL;  // Avoid dangling pointer

    printf("Memory freed.\n");

    // Dereferencing NULL pointers to show safe practice
    if (p) {
        printf("*(p+4) = %d\n", *(p+4));
    } else {
        printf("p is NULL\n");
    }

    if (x) {
        printf("*x = %d\n", *x);
    } else {
        printf("x is NULL\n");
    }

    return 0;
}