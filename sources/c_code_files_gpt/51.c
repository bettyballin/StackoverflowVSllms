#include <windows.h>

void* allocate_executable_memory(size_t size) {
    return VirtualAlloc(NULL, size, MEM_COMMIT | MEM_RESERVE, PAGE_EXECUTE_READWRITE);
}

int main() {
    // Example usage
    size_t size = 1024; // Allocate 1KB of executable memory
    void* ptr = allocate_executable_memory(size);
    if (!ptr) {
        // Allocation failed
        return 1;
    }
    // Allocation succeeded
    // Don't forget to free the memory when done
    VirtualFree(ptr, 0, MEM_RELEASE);
    return 0;
}