#include <stdio.h>

int main() {
    #pragma GCC push_options
    #pragma GCC optimize ("O0")
    // Code that causes issues with optimization
    printf("This part of the code is not optimized.\n");
    #pragma GCC pop_options
    
    // Example code to contrast with optimized code
    printf("Optimizations are back to default.\n");
    
    return 0;
}