#include <windows.h>

int main() {
    HWND window_hwnd = /* Initialize window handle */;
    SendMessage(SHFindMenuBar(window_hwnd), 
                SHCMBM_OVERRIDEKEY, 
                VK_TTALK, 
                MAKELPARAM((SHMBOF_NODEFAULT|SHMBOF_NOTIFY), (SHMBOF_NODEFAULT|SHMBOF_NOTIFY)));
    return 0;
}