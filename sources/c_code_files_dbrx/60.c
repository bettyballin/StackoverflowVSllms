#include <fcntl.h>
#include <sys/mman.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>

// Define the structure
typedef struct {
    // Add your structure members here
} MyStruct;

int main() {
    // Define the shared file name
    char* theSharedFileName = "shared_file";
    int fileSize = 1024; // Replace with the actual file size

    // Open the shared file
    int sharedFileName = open(theSharedFileName, O_RDWR);
    if (sharedFileName == -1) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    // Map the shared file to memory
    MyStruct* sharedArea = (MyStruct*)mmap(NULL, fileSize, PROT_READ | PROT_WRITE | PROT_EXEC, MAP_SHARED, sharedFileName, 0);
    if (sharedArea == MAP_FAILED) {
        perror("Error mapping file to memory");
        close(sharedFileName);
        exit(EXIT_FAILURE);
    }

    // Don't forget to close the file descriptor and unmap the memory when you're done
    // close(sharedFileName);
    // munmap(sharedArea, fileSize);

    return 0;
}