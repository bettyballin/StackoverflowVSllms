#include <emmintrin.h>
#include <stddef.h>
#include <string.h> // For memcmp

int fast_memcmp(const void *s1, const void *s2, size_t n) {
    const __m128i *p1 = (const __m128i*)s1;
    const __m128i *p2 = (const __m128i*)s2;
    
    size_t i;
    for (i = 0; i < n / 16; ++i) {
        __m128i eq = _mm_cmpeq_epi8(p1[i], p2[i]);
        int mask = _mm_movemask_epi8(eq);
        if (mask != 0xFFFF) {
            return memcmp(&p1[i], &p2[i], 16);
        }
    }

    // Handle the remaining bytes
    const unsigned char *c1 = (const unsigned char*)&p1[i];
    const unsigned char *c2 = (const unsigned char*)&p2[i];
    for (i = (n / 16) * 16; i < n; ++i) {
        if (c1[i] != c2[i]) {
            return c1[i] - c2[i];
        }
    }
    return 0;
}

int main() {
    // Example usage:
    char str1[] = "Hello, World!";
    char str2[] = "Hello, World!";
    size_t len = strlen(str1);

    int result = fast_memcmp(str1, str2, len);
    return result;
}