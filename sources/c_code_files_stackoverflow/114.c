#include <stdbool.h>

bool lowestPositive(int a, int b, int* result) {
    if (a > 0 && a <= b) // a is positive and smaller than or equal to b
        *result = a;
    else if (b > 0) // b is positive and either smaller than a or a is negative
        *result = b;
    else
        *result = a; // at least b is negative, we might not have an answer

    return *result > 0;  // zero is not positive
}