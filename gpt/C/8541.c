#include <stdio.h>\n   #include <stdint.h>\n   #include <x86intrin.h> // for __rdtscp and _mm_clflush with MSVC, use <intrin.h>\n   \n   uint64_t measure_access_time(void *addr) {\n       uint64_t start, end;\n       volatile uint64_t value;\n\n       start = __rdtscp(&value);\n       value = *(volatile uint64_t *)addr;\n       end = __rdtscp(&value);\n\n       return end - start;\n   }\n\n   int main() {\n       uint64_t data;\n       _mm_clflush(&data); // Flush the cache line containing &data\n       uint64_t time = measure_access_time(&data);\n       printf("Access time after flush: %llu\n", time);\n       return 0;\n   }