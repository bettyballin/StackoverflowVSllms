#include <windows.h>

// some data will be shared across all instances of the DLL
#pragma data_seg(".SHARED")
int iKeyCount = 0;
HHOOK hKeyboardHook = 0;
HHOOK hMouseHook = 0;
#pragma data_seg()

// instance specific data
HMODULE hInstance = 0;

// DLL load/unload entry point
BOOL WINAPI DllMain(HINSTANCE hModule, DWORD dwReason, LPVOID lpReserved)
{
    switch (dwReason)
    {
    case DLL_PROCESS_ATTACH:
        hInstance = hModule;
        break;

    case DLL_THREAD_ATTACH:
        break;

    case DLL_THREAD_DETACH:
        break;

    case DLL_PROCESS_DETACH:
        break;
    }
    return TRUE;
}

// keyboard hook
LRESULT CALLBACK KeyboardProc(int code, WPARAM wParam, LPARAM lParam)
{
    if ((lParam & 0x80000000) != 0)
    {
        ++iKeyCount;
    }
    return CallNextHookEx(hKeyboardHook, code, wParam, lParam);
}

// mouse hook
LRESULT CALLBACK MouseProc(int code, WPARAM wParam, LPARAM lParam)
{
    switch (wParam)
    {
    case WM_LBUTTONDOWN:
    case WM_MBUTTONDOWN:
    case WM_RBUTTONDOWN:
    case WM_LBUTTONDBLCLK:
    case WM_MBUTTONDBLCLK:
    case WM_RBUTTONDBLCLK:
        ++iKeyCount;
        break;
    }
    return CallNextHookEx(hMouseHook, code, wParam, lParam);
}

// install keyboard/mouse hooks
void InstallHooks(void)
{
    hKeyboardHook = SetWindowsHookEx(WH_KEYBOARD, KeyboardProc, hInstance, 0);
    hMouseHook = SetWindowsHookEx(WH_MOUSE, MouseProc, hInstance, 0);
}

// remove keyboard/mouse hooks
void RemoveHooks(void)
{
    UnhookWindowsHookEx(hKeyboardHook);
    UnhookWindowsHookEx(hMouseHook);
    hKeyboardHook = hMouseHook = 0;
}

// retrieve number of keystrokes
int FetchKeyCount(bool bClear)
{
    int kc = iKeyCount;
    if (bClear)
        iKeyCount = 0;
    return kc;
}