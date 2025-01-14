#include <unistd.h>
#include <libgen.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void goUpDir() {
    char newDir[50] = "";
    // Get the current directory
    char *currentDir = get_current_dir_name();
    // Go up one directory level
    dirname(currentDir);
    // Copy the new directory to the newDir variable
    strncpy(newDir, currentDir, 49);
    free(currentDir);  // Don't forget to free the allocated memory
    printf("New directory: %s\n", newDir);
}

void goIntoDir() {
    char *oldDir;
    char newDir[50] = "";
    
    oldDir = get_current_dir_name();
    printf("Old directory: %s\n", oldDir);
    // chdir() is used to change the current working directory.
    // For example, let's go into a directory named "test"
    strcat(newDir, oldDir);
    strcat(newDir, "/test");
    chdir(newDir);
    free(oldDir);  // Don't forget to free the allocated memory
}

int main() {
    goUpDir();
    goIntoDir();
    return 0;
}