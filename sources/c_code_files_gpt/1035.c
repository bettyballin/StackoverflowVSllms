#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

typedef struct {
    int x;
    float y;
} MyStruct;

const char *sharedFileName = "sharedfile";
const size_t fileSize = sizeof(MyStruct);

int main() {
    FILE* tempFile = fopen(sharedFileName, "r+");
    if (tempFile == NULL) {
        perror("fopen");
        exit(EXIT_FAILURE);
    }

    int theFile = fileno(tempFile);

    MyStruct* sharedArea = (MyStruct*)mmap(NULL, fileSize,
        PROT_READ | PROT_WRITE, MAP_SHARED, theFile, 0);

    if (sharedArea == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    // Access sharedArea as needed
    sharedArea->x = 10;
    sharedArea->y = 3.14;
    printf("Shared area: x = %d, y = %f\n", sharedArea->x, sharedArea->y);

    fclose(tempFile);
    // Continue with the rest of the code
    return 0;
}