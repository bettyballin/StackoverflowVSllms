#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>

int count_files(const char *path) {
    struct dirent *entry;
    DIR *dp = opendir(path);
    int count = 0;

    if (dp == NULL) {
        perror("opendir");
        return -1;
    }

    while ((entry = readdir(dp))) {
        // Skip the special entries "." and ".."
        if (entry->d_type == DT_REG) {
            count++;
        }
    }

    closedir(dp);
    return count;
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <directory_path>\n", argv[0]);
        return 1;
    }

    int file_count = count_files(argv[1]);
    if (file_count >= 0) {
        printf("Number of files: %d\n", file_count);
    } else {
        fprintf(stderr, "Failed to count files in the directory\n");
    }

    return 0;
}