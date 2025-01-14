#include <stdio.h>
#include <stdbool.h>

// Function prototypes
void* compressData();
void writeInDisk(void* data);
void* readFromDisk();
void decompressAndUseData(void* data);

void handle_io(bool isWriteOperation) {
    if (isWriteOperation) {
        // Compress data before writing to disk
        void* compressedData = compressData();
        writeInDisk(compressedData);
    } else {
        // Decompress and read from disk on need basis
        void* data = readFromDisk();
        decompressAndUseData(data);
    }
}

// Dummy implementations for the function prototypes
void* compressData() {
    printf("Compressing data...\n");
    return NULL; // Replace with actual implementation
}

void writeInDisk(void* data) {
    printf("Writing data to disk...\n");
    // Replace with actual implementation
}

void* readFromDisk() {
    printf("Reading data from disk...\n");
    return NULL; // Replace with actual implementation
}

void decompressAndUseData(void* data) {
    printf("Decompressing and using data...\n");
    // Replace with actual implementation
}

int main() {
    handle_io(true);  // Test write operation
    handle_io(false); // Test read operation
    return 0;
}