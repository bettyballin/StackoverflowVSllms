#include <sys/mman.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    size_t length = 4096; // Size of the memory to allocate
    void *addr = mmap(NULL, length, PROT_READ | PROT_WRITE, MAP_ANONYMOUS | MAP_PRIVATE, -1, 0);
    
    if (addr == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    // Use the allocated memory
    printf("Memory allocated at address %p\n", addr);

    // Clean up
    if (munmap(addr, length) == -1) {
        perror("munmap");
        exit(EXIT_FAILURE);
    }

    return 0;
}