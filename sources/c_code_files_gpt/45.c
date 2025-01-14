#include <windows.h>
#include <stdio.h>

int main() {
    const char *filePath = "C:\\path\\to\\your\\file_or_directory";

    // Set the file attribute to hidden
    if (SetFileAttributesA(filePath, FILE_ATTRIBUTE_HIDDEN)) {
        printf("The file or directory has been successfully hidden.\n");
    } else {
        printf("Failed to hide the file or directory. Error code: %lu\n", GetLastError());
    }

    return 0;
}