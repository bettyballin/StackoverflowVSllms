#include <stdio.h>

void resetCursor()
{
#ifdef _WIN32
    // Windows-specific code
    printf("\033[H");
#else
    // Linux-specific code
    printf("\033[H");
#endif
}

int main() {
    // Example usage
    printf("This will be cleared.\n");
    printf("This too will be cleared.\n");

    // Reset cursor to (0,0)
    resetCursor();

    // Print overlaying text
    printf("New text at the top of the screen.\n");

    return 0;
}