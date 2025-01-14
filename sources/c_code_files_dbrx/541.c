#include <stdio.h>

// Dummy implementations for demonstration purposes
void ProfilerStart(const char* filename) {
    printf("Starting profiler with file: %s\n", filename);
}

void HeapLeakCheckerInit() {
    printf("Initializing heap leak checker\n");
}

int main() {
    ProfilerStart("profile_log\\");     // create a file named 'profile_log' in current dir, change directory as needed
    HeapLeakCheckerInit();              // Initiate heap consistency checker
    return 0;
}