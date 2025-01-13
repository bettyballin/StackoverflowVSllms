#include <emmintrin.h> // SSE2 header\n\nfloat a[4] __attribute__((aligned(16))) = { 10, 20, 30, 40 };\nfloat b[4] __attribute__((aligned(16))) = { 0.1, 0.1, 0.1, 0.1 };\n\n__m128 va = _mm_load_ps(a); // Load a into xmm0\n__m128 vb = _mm_load_ps(b); // Load b into xmm0\n\nvb = _mm_mul_ps(va, vb);   // Multiply the two vectors element-wise\n\n_mm_store_ps(b, vb);        // Store the result back to array b