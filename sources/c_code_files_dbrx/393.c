#include <cpuid.h>
#include <stdbool.h> // For bool
#include <stdio.h>   // For printf (optional, but useful for testing)

int main() {
    unsigned int cpuinfo[4];
    __get_cpuid(0x1, &cpuinfo[0], &cpuinfo[1], &cpuinfo[2], &cpuinfo[3]);
    bool sse2Available = ((cpuinfo[2] >> 26) & 1) == 1;
    
    // Optionally, print the result for verification
    printf("SSE2 Available: %s\n", sse2Available ? "Yes" : "No");
    
    return 0;
}