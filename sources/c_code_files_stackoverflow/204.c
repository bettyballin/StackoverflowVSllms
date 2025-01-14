#include <dirent.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    int file_count = 0;
    DIR *dirp;
    struct dirent *entry;

    dirp = opendir("path");
    if (dirp == NULL) {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    while ((entry = readdir(dirp)) != NULL) {
        if (entry->d_type == DT_REG) { /* If the entry is a regular file */
            file_count++;
        }
    }

    if (closedir(dirp) != 0) {
        perror("closedir");
        exit(EXIT_FAILURE);
    }

    printf("Number of regular files: %d\n", file_count);

    return 0;
}