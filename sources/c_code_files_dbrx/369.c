#include <windows.h>

int main() {
    MSG msg;
    while ((PeekMessage(&msg, NULL, 0, 0, PM_REMOVE)) > 0) {
        if (msg.message == WM_QUIT) break;
        TranslateMessage(&msg); 
        DispatchMessage(&msg); 
    }
    return 0;
}