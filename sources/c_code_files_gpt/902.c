#include <stdio.h>
#include <sys/mman.h>

int main() {
    void* address = NULL; // Replace with the desired address
    size_t size = 0; // Replace with the desired size

    int oldProtect = 0;
    int result = mprotect(address, size, PROT_READ);
    if (result == -1) {
        perror("mprotect");
        return 1;
    }

    return 0;
}