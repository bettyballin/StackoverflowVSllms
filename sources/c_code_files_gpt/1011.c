#include <windows.h>
#include <stdio.h> // Include this for printf

int main() {
    // Attach to the parent process's console
    AttachConsole(ATTACH_PARENT_PROCESS);
    // Now you can use standard I/O functions like printf, scanf, etc.
    printf("This is the parent console window.\n"); // Added newline character
    return 0;
}