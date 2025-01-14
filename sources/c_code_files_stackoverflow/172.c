#include <stdio.h>

// Precomputed array of factorials
int precomputedArray[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

int factorial(int x)
{
  // Check if x is within the bounds of the precomputed array
  if (x < 0 || x >= sizeof(precomputedArray) / sizeof(precomputedArray[0])) {
    printf("Error: factorial not precomputed for %d\n", x);
    return -1; // or some other error value
  }
  return precomputedArray[x];
}

int main() {
  printf("Factorial of 5: %d\n", factorial(5));
  return 0;
}