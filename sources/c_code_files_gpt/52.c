#include <sys/mman.h>
#include <stdio.h>

void* allocate_executable_memory(size_t size) {
    return mmap(NULL, size, PROT_READ | PROT_WRITE | PROT_EXEC, MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);
}

int main() {
    // Test the function
    void* ptr = allocate_executable_memory(1024);
    if (ptr == MAP_FAILED) {
        perror("mmap");
        return 1;
    }
    printf("Allocated executable memory at address %p\n", ptr);
    return 0;
}