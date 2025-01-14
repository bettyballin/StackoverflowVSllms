#include <windows.h>

int main() {
    HANDLE hEvent = CreateEvent(NULL, FALSE, FALSE, NULL);
    return 0;
}