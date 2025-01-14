#include <stdio.h>
#include <stdlib.h>

int main() {
    char fpath[256];
    const char *file = "/test/file.this";
    snprintf(fpath, sizeof(fpath), "/home/courses1/cs4352/projects/proj0%s", file);

    FILE *fp = fopen(fpath, "r");
    if (fp == NULL) {
        perror("Error opening file");
        return 1;
    }
    fclose(fp);
    printf("File is readable\n");
    //do more stuff

    return 0;
}