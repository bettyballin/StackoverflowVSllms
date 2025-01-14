#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h> // Include sys/mman.h for mmap and munmap
#include <stdio.h>    // Include stdio.h for perror

int main() {
    size_t size = 1024; // Define the size of the memory to be allocated

    void *ptr = mmap(NULL, size, PROT_EXEC | PROT_READ  | PROT_WRITE, MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);
    if (ptr == MAP_FAILED) {
        perror("mmap"); // Error handling using perror
        return 1;       // Return an error code
    }
    // Use allocated memory for JIT

    if (munmap(ptr, size) != 0) {
        perror("munmap"); // Error handling using perror
        return 1;         // Return an error code
    }

    return 0; // Return success code
}