#include <stdio.h>
#include <windows.h>

#define COLS 80
#define ROWS 25

int main() {
    HANDLE hOutput;
    SMALL_RECT windowSize = {0, 0, COLS - 1, ROWS};
    COORD bufferSize = {COLS, ROWS};
    SMALL_RECT* pWindowSize = &windowSize;
    COORD* pBufferSize = &bufferSize;

    hOutput = GetStdHandle(STD_OUTPUT_HANDLE);
    if (hOutput == INVALID_HANDLE_VALUE) {
        printf("Failed to get standard output handle.\n");
        return 1; // Return with failure
    }

    if (!SetConsoleScreenBufferSize(hOutput, *pBufferSize)) {
        printf("Failed to set console screen buffer size.\n");
        return 1; // Return with failure
    }

    if (!SetConsoleWindowInfo(hOutput, TRUE, *pWindowSize)) {
        printf("Failed to set console window info.\n");
        return 1; // Return with failure
    }

    return 0; // Successful execution
}