#include <smmintrin.h>

// Function to demonstrate the use of __m128 type
void exampleFunction() {
    __m128 var; // Defined as part of function scope
    
    // Initialize var to zero (optional, but often necessary for further operations)
    var = _mm_setzero_ps();
    
    // Example operation (optional)
    var = _mm_add_ps(var, var); // Adds var to itself, result in var
    
    // You may need to store the result or perform other operations here
    // For this example, no further action is taken
}

int main() {
    exampleFunction();
    return 0;
}