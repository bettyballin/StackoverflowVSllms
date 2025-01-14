#include <stdio.h>
#include <stdint.h>
#include <x86intrin.h> // for __rdtscp and _mm_clflush, with MSVC, use <intrin.h>

uint64_t measure_access_time(void *addr) {
    uint64_t start, end;
    volatile uint64_t value;

    start = __rdtscp(&value);
    value = *(volatile uint64_t *)addr;
    end = __rdtscp(&value);

    return end - start;
}

int main() {
    uint64_t data;
    _mm_clflush(&data); // Flush the cache line containing &data
    uint64_t time = measure_access_time(&data);
    printf("Access time after flush: %llu\n", time);
    return 0;
}