#include <stdio.h>
#include <sys/mman.h>

// This address should match with what was returned by `mmap` in parent process.
void *shared_mem = (void*)0x7f3d495a6000; // replace this with correct shared memory address from the output of your program run when mapping the MAP_ANONYMOUS area in the parent process

int main() {
    printf("Child received message: %s\n", (char*)shared_mem); // Read from shared memory and print to stdout.
    return 0;
}