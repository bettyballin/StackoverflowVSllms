#include <windows.h>

int main() {
    int condition = 1;

    if (condition) {
        DebugBreak(); // Add this statement where you want the application to stop when condition is met.
    }

    return 0;
}