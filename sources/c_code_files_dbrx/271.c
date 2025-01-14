#include <stdint.h>
#include <stdio.h> // added for printf

uint32_t fnv1a_32(const char* key, size_t len) {
    uint32_t hash = 0x811C9DC5; // FNV_offset_basis
    for (size_t i = 0; i < len; ++i) {
        hash ^= (uint8_t)key[i];
        hash *= 0x1000193; // FNV_prime
    }
    return hash;
}

int main() {
    const char* test_string = "Hello, World!";
    uint32_t hash = fnv1a_32(test_string, sizeof(test_string) - 1); // -1 to exclude null terminator
    printf("Hash: 0x%08x\n", hash);
    return 0;
}