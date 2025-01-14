#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

// Define the structure
typedef struct {
    // Add your structure members here
    int exampleMember;
} MyStruct;

const char *theSharedFileName = "sharedfile";
const size_t fileSize = sizeof(MyStruct);

int main() {
    FILE* temp = fopen(theSharedFileName, "w+");
    if (temp == NULL) {
        perror("fopen");
        exit(EXIT_FAILURE);
    }

    if (ftruncate(fileno(temp), fileSize) == -1) {
        perror("ftruncate");
        exit(EXIT_FAILURE);
    }

    int sharedFileName = fileno(temp);

    MyStruct* sharedArea = (MyStruct*)mmap(0, fileSize,
        PROT_READ | PROT_WRITE, MAP_SHARED, sharedFileName, 0);

    if (sharedArea == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    // Initialize sharedArea if necessary
    sharedArea->exampleMember = 0;  // Initialize the example member

    fclose(temp);
    // Continue with the rest of the code

    // Don't forget to unmap the shared memory when you're done
    if (munmap(sharedArea, fileSize) == -1) {
        perror("munmap");
        exit(EXIT_FAILURE);
    }

    return 0;
}