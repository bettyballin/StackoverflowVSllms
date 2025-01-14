#include <stdio.h>

int main() {
    // assuming files is an array of strings
    char *files[] = {"file1", "file2", "file3", NULL};

    for (int x = 1; x < sizeof(files) / sizeof(files[0]); x++) {
        printf("%s\n", files[x]);
    }

    return 0;
}