#include <stdio.h>

typedef long long Bignum;

Bignum modpow(Bignum base, Bignum exponent, Bignum modulus) {

    Bignum result = 1;

    while (exponent > 0) {
        if ((exponent & 1) == 1) {
            // multiply in this bit's contribution while using modulus to keep result small
            result = (result * base) % modulus;
        }
        // move to the next bit of the exponent, square (and mod) the base accordingly
        exponent >>= 1;
        base = (base * base) % modulus;
    }

    return result;
}

int main() {
    Bignum base, exponent, modulus;
    printf("Enter base: ");
    scanf("%lld", &base);
    printf("Enter exponent: ");
    scanf("%lld", &exponent);
    printf("Enter modulus: ");
    scanf("%lld", &modulus);
    printf("Result: %lld\n", modpow(base, exponent, modulus));
    return 0;
}