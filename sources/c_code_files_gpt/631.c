#include <windows.h>
#include <stdio.h>

void DeleteAndCopyFiles(const char* source, const char* destination) {
    // Delete the destination file if it exists
    if (!DeleteFileA(destination)) {
        DWORD error = GetLastError();
        if (error != ERROR_FILE_NOT_FOUND) {
            printf("Failed to delete file. Error: %lu\n", error);
            return;
        }
    }

    // Copy the source file to the destination
    if (!CopyFileA(source, destination, FALSE)) {
        DWORD error = GetLastError();
        printf("Failed to copy file. Error: %lu\n", error);
    } else {
        printf("File copied successfully.\n");
    }
}

int main() {
    const char* source = "source.txt";
    const char* destination = "destination.txt";

    DeleteAndCopyFiles(source, destination);

    return 0;
}