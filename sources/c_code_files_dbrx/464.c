#include <stdio.h>  // For standard input/output functions
#include <string.h> // For string manipulation functions
#include <unistd.h> // For chdir() function, to change the directory

// Function to go up one directory level
void goUpDir() {
    // chdir("..") changes the directory to the parent directory
    if (chdir("..") != 0) {
        perror("Error going up a directory");
    } else {
        printf("Moved up one directory level successfully.\n");
    }
}

int main() {
    printf("Current working directory: \n");
    // Use system call to print the current working directory
    system("pwd");
    
    goUpDir();
    
    printf("Directory after moving up: \n");
    system("pwd");
    
    return 0;
}