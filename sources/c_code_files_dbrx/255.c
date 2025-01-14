#include <Windows.h>

int main() {
    HANDLE read_end;
    HANDLE write_end;
    SECURITY_ATTRIBUTES sa = { sizeof(sa), NULL, TRUE };
    CreatePipe(&read_end, &write_end, &sa, 0);
    return 0;
}