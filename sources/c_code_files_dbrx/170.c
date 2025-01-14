#include <windows.h>

int main() {
    #ifdef _M_IX86
        if (IsProcessorFeaturePresent(PF_SSE2_INSTRUCTIONS_AVAILABLE)) {
            LoadLibraryA("sse2.dll");
        } else /* PF_FPU_INSTRUCTIONS_AVAILABLE */ {
            LoadLibraryA("no-sse.dll"); // fallback module for earlier CPUs
        }
    #elif _M_X64
        LoadLibraryA("avx2.dll"); // AVX instructions are mandatory in long mode.
    #else
        #error Unknown architecture!
    #endif // CPU features

    return 0;
}