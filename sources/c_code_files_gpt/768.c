#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

void sieveOfEratosthenes(int n) {
    int *prime = malloc((n+1) * sizeof(int));
    memset(prime, 1, (n+1) * sizeof(int));

    for (int p = 2; p * p <= n; p++) {
        if (prime[p] == 1) {
            for (int i = p * p; i <= n; i += p)
                prime[i] = 0;
        }
    }

    // Uncomment to print primes
    // for (int p = 2; p <= n; p++)
    //     if (prime[p])
    //         printf("%d ", p);
    // printf("\n");

    free(prime);
}

int main() {
    int n = 10000000; // Change this to increase/decrease computation
    clock_t start = clock();
    sieveOfEratosthenes(n);
    clock_t end = clock();
    printf("Time taken: %f seconds\n", (double)(end - start) / CLOCKS_PER_SEC);
    return 0;
}