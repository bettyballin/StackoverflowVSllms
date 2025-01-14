#include <stdio.h>
#include <stdlib.h>

// Structure to hold file pointer, since FILE is opaque
typedef struct {
    FILE* pointer;
} FileWrapper;

FileWrapper* open_file(char *path) {
    FileWrapper *file = (FileWrapper *)malloc(sizeof(FileWrapper));
    file->pointer = fopen(path, "w");
    return file;
}

void close_and_free_file(FileWrapper *file){
    fclose(file->pointer);
    free(file);
}