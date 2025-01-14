#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <string.h>

// Sample machine code for x86-64 that just returns 42
unsigned char code[] = {
    0xB8, 0x2A, 0x00, 0x00, 0x00, // mov eax, 42
    0xC3                          // ret
};

int main() {
    // Allocate memory with read, write, and execute permissions
    void *exec_mem = mmap(NULL, sizeof(code), PROT_READ | PROT_WRITE | PROT_EXEC, 
                          MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);
    if (exec_mem == MAP_FAILED) {
        perror("mmap");
        return 1;
    }

    // Copy the machine code into the allocated memory
    memcpy(exec_mem, code, sizeof(code));

    // Cast the memory to a function pointer and call it
    int (*func)() = (int (*)())exec_mem;
    int result = func();
    
    printf("Result: %d\n", result);

    // Free the allocated memory
    munmap(exec_mem, sizeof(code));

    return 0;
}