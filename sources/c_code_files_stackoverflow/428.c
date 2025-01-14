#include <windows.h>

int main() {
    HANDLE hStdIn = GetStdHandle(STD_INPUT_HANDLE);
    if (hStdIn == INVALID_HANDLE_VALUE) {
        // Handle error
        return 1;
    }
    // Use the handle as needed
    return 0;
}