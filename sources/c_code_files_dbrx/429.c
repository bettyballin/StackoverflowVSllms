#include <stdio.h>

__attribute__ ((visibility ("hidden"))) int a = 10; // Initialize 'a'
__attribute__ ((visibility ("default"))) int b = 20; // Initialize 'b'

int main() {
    // Modify and use 'a' within this executable
    a += 5;
    printf("Value of a (hidden visibility): %d\n", a);
    
    // Use 'b', which is accessible from outside this executable
    printf("Value of b (default visibility): %d\n", b);
    
    return 0;
}