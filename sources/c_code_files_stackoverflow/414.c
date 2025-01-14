#include <stdio.h>

// Function to calculate the binomial coefficient n choose k
long long choose(int n, int k) {
    if (k > n - k) // Take advantage of symmetry property, since n choose k = n choose (n-k)
        k = n - k;
    long long result = 1;
    for (int i = 0; i < k; ++i) {
        result = result * (n - i) / (i + 1);
    }
    return result;
}

/** [combination c n p x]
 * get the [x]th lexicographically ordered set of [p] elements in [n]
 * output is in [c], and should be sizeof(int)*[p] */
void combination(int* c, int n, int p, int x) {
    int i, r, k = 0;
    for (i = 0; i < p - 1; i++) {
        c[i] = (i != 0) ? c[i - 1] : 0;
        do {
            c[i]++;
            r = choose(n - c[i], p - (i + 1));
            k = k + r;
        } while (k < x);
        k = k - r;
    }
    c[p - 1] = c[p - 2] + x - k;
}

int main() {
    int n = 10; // Example: choosing from a set of 10 elements
    int p = 3;  // Example: choosing 3 elements
    int x = 5;  // Example: finding the 5th combination
    int c[p];
    
    combination(c, n, p, x);
    
    printf("The %dth combination of %d elements from a set of %d is: ", x, p, n);
    for (int i = 0; i < p; ++i) {
        printf("%d ", c[i]);
    }
    printf("\n");
    
    return 0;
}