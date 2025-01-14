#include <sys/mman.h>
#include <unistd.h>
#include <string.h>

void* allocate_writable_memory(size_t size) {
    return mmap(NULL, size, PROT_READ | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);
}

void make_memory_executable(void* addr, size_t size) {
    mprotect(addr, size, PROT_READ | PROT_EXEC);
}

int main() {
    size_t size = 4096;
    void* mem = allocate_writable_memory(size);

    // Write your JIT-compiled code to mem here...

    make_memory_executable(mem, size);

    // Now you can execute code in mem...

    return 0;
}