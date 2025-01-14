#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

// Define the structure for shared memory
typedef struct {
    // Add your structure members here
} MyStruct;

int main() {
    const char *theSharedFileName = "shared_file"; // Replace with your shared file name
    size_t fileSize = 1024; // Replace with your desired file size
    int sharedFileName;
    MyStruct *sharedArea;
    FILE *temp;

    // Opening file with O_RDWR, which will allow reading & writing; also creating if not exist or truncating existing one with O_CREAT | O_TRUNC flags
    sharedFileName = open(theSharedFileName, O_RDWR | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);
    if (sharedFileName == -1) {
        perror("Error opening file");
        exit(1);
    }

    // Create a temporary file pointer to set the file size
    temp = fdopen(sharedFileName, "w+");
    if (temp == NULL) {
        perror("Error creating temporary file pointer");
        close(sharedFileName);
        exit(1);
    }

    // If you want to set the size of the shared file to a specific value, use ftruncate() here instead.
    fseek(temp, fileSize-1, SEEK_SET);
    fprintf(temp, "0"); // make the file a certain size
    fseek(temp, 0, SEEK_CUR);

    // Close the temporary file pointer
    fclose(temp);

    // Now you can mmap it. Make sure fileSize is properly initialized as the desired length of your shared data area in bytes.
    sharedArea = (MyStruct*)mmap(NULL, fileSize, PROT_READ | PROT_WRITE, MAP_SHARED, sharedFileName, 0);
    if ((void *)sharedArea == MAP_FAILED) {
        perror("Error mapping file to memory");
        close(sharedFileName);
        unlink(theSharedFileName);
        exit(1);
    }

    // Don't forget to unmap and close the file when you're done
    munmap(sharedArea, fileSize);
    close(sharedFileName);
    unlink(theSharedFileName);

    return 0;
}