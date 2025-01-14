#include <windows.h>

BOOL WINAPI SetConsoleCtrlHandler(
    PHANDLER_ROUTINE HandlerRoutine,    // address of handler function  
    BOOL Add    // handler to add or remove 
);

int main() {
    // To use the SetConsoleCtrlHandler function, you would need to define a handler function
    // and then call SetConsoleCtrlHandler with the address of that function and a boolean
    // indicating whether to add or remove the handler.

    // Here's an example of how you might use it:
    // BOOL WINAPI CtrlHandler(DWORD fdwCtrlType) {
    //     switch (fdwCtrlType) {
    //         case CTRL_C_EVENT:
    //             printf("Ctrl-C event\n\n");
    //             Beep(750, 300);
    //             return TRUE;
    // 
    //         case CTRL_BREAK_EVENT:
    //             printf("Ctrl-Break event\n\n");
    //             Beep(750, 300);
    //             return FALSE;
    // 
    //         case CTRL_CLOSE_EVENT:
    //             printf("Ctrl-Close event\n\n");
    //             Beep(750, 300);
    //             return TRUE;
    // 
    //         case CTRL_LOGOFF_EVENT:
    //         case CTRL_SHUTDOWN_EVENT:
    //             printf("Ctrl-Logoff/Shutdown event\n\n");
    //             Beep(750, 300);
    //             return FALSE;
    // 
    //         default:
    //             return FALSE;
    //     }
    // }
    // 
    // SetConsoleCtrlHandler(CtrlHandler, TRUE);
    return 0;
}