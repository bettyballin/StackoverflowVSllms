#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to generate a large random prime number
long long generate_large_prime() {
    long long prime;
    int is_prime = 0;

    while (!is_prime) {
        prime = (rand() % 9000) + 1000; // Generate a random number between 1000 and 9999

        // Check if the generated number is prime
        is_prime = 1;
        for (long long i = 2; i * i <= prime; i++) {
            if (prime % i == 0) {
                is_prime = 0;
                break;
            }
        }
    }

    return prime;
}

// Function to generate a public key
long long generate_public_key(long long phi) {
    long long e;

    // Choose a public key e such that it is coprime to phi and less than it
    do {
        e = (rand() % (phi - 2)) + 2; // Generate a random number between 2 and phi-1
    } while (gcd(e, phi) != 1);

    return e;
}

// Function to calculate the greatest common divisor (GCD)
long long gcd(long long a, long long b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

// Function to find the private key using Extended Euclidean Algorithm
long long find_private_key(long long e, long long phi) {
    long long d, x, y;

    extended_euclidean(e, phi, &x, &y);

    if (x < 0)
        x += phi;

    return x;
}

// Function to perform Extended Euclidean Algorithm
void extended_euclidean(long long a, long long b, long long *x, long long *y) {
    if (a == 0) {
        *x = 0;
        *y = 1;
        return;
    }

    long long x1, y1;
    extended_euclidean(b % a, a, &x1, &y1);

    *x = y1 - (b / a) * x1;
    *y = x1;
}

int main() {
    srand(time(NULL)); // Seed for random number generation

    // Generate two large random primes p and q
    long long p = generate_large_prime();
    long long q = generate_large_prime();

    // Compute n, 'modulus', as product of these primes
    long long n = p * q;

    // Calculate Euler's totient function
    long long phi = (p - 1) * (q - 1);

    // Choose public key pair e such that it is coprime to phi and less than it
    long long e = generate_public_key(phi);

    // Find the private key d using Extended Euclidean Algorithm so that ed congruent to 1 modulo phi
    long long d = find_private_key(e, phi);

    printf("Public Key (e, n): (%lld, %lld)\n", e, n);
    printf("Private Key (d, n): (%lld, %lld)\n", d, n);

    return 0;
}