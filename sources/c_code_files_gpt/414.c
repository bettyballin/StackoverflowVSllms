#include <assert.h>
#include <math.h>
#include <stdio.h> // Include stdio.h for printf

float sqrt_non_negative(float value) {
    assert(value >= 0.0f); // Ensure the value is non-negative
    return sqrtf(value);
}

int main() {
    float test_value = 4.0f; // Test with a non-negative value
    float result = sqrt_non_negative(test_value);
    printf("The square root of %.2f is %.2f\n", test_value, result);
    return 0;
}