#include <gmp.h>

int main() {
    mpz_t largeInt;
    mpz_init(largeInt);
    mpz_set_str(largeInt, "123456789123456789123456789", 10);
    mpz_clear(largeInt);
    return 0;
}