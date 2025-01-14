#include <windows.h>

void* allocate_writable_memory(size_t size) {
    return VirtualAlloc(NULL, size, MEM_COMMIT | MEM_RESERVE, PAGE_READWRITE);
}

void make_memory_executable(void* addr, size_t size) {
    DWORD oldProtect;
    VirtualProtect(addr, size, PAGE_EXECUTE_READ, &oldProtect);
}

int main() {
    size_t size = 4096;
    void* mem = allocate_writable_memory(size);

    // Write your JIT-compiled code to mem here...

    make_memory_executable(mem, size);

    // Now you can execute code in mem...

    return 0;
}