#include <stdio.h>
#include <string.h>

// Placeholder function for AddFiles, as its implementation is unknown
void AddFiles(const char* path) {
    printf("Adding files at path: %s\n", path);
}

int main() {
    char path[256] = "/example/path"; // Assuming a starting path
    char srName[256] = "filename.txt"; // Assuming sr.Name is a filename

    // Ensure the path has enough space to append more characters
    if (strlen(path) + strlen(srName) + 2 < 256) {
        // Append \\ and srName to path
        strcat(path, "\\");
        strcat(path, srName);

        // Call AddFiles with the new path
        AddFiles(path);
    } else {
        printf("Path too long!\n");
    }

    return 0;
}