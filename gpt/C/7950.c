#include <emmintrin.h>\n\n   void process(float *a, float *b, float *c) {\n       __asm__ (\n           "movaps (%0), %%xmm0\n"\n           "movaps (%1), %%xmm1\n"\n           "addps %%xmm1, %%xmm0\n"\n           "movaps %%xmm0, (%2)\n"\n           : // no output operands\n           : "r"(a), "r"(b), "r"(c)\n           : "%xmm0", "%xmm1"\n       );\n   }