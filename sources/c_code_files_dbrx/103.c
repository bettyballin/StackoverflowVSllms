#include <stdio.h>

int main() {
    int a[] = {3, 1, 2, 3}; // Example array, first element is used in indexing
    
    printf("%p %p %p %p\n", (void*)&a[a[0]], &a[1], &a[2], &a[3]);
    
    return 0;
}