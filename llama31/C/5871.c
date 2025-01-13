float a[4] __attribute__((aligned(16))) = { 10, 20, 30, 40 };\nfloat b[4] __attribute__((aligned(16))) = { 0.1, 0.1, 0.1, 0.1 };\nfloat result[4] __attribute__((aligned(16)));\n\nasm volatile(\n    "movaps (%0), %%xmm0\n\t"  // load a into xmm0\n    "movaps (%1), %%xmm1\n\t"  // load b into xmm1\n    "mulps %%xmm1, %%xmm0\n\t"  // multiply xmm0 and xmm1\n    "movaps %%xmm0, (%2)\n\t"  // store result in result array\n    :\n    : "r" (a), "r" (b), "r" (result)\n    : "xmm0", "xmm1"\n);