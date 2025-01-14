#include <Windows.h>

// Handler function
BOOL WINAPI CtrlHandler(DWORD fdwCtrlType) 
{ 
    switch(fdwCtrlType) 
    { 
        case CTRL_C_EVENT:
            printf("Ctrl-C event\n\n");
            return TRUE;

        case CTRL_CLOSE_EVENT:
            printf("Ctrl-Close event\n\n"); 
            return TRUE;

        case CTRL_BREAK_EVENT:
            printf("Ctrl-Break event\n\n");
            return FALSE;

        case CTRL_LOGOFF_EVENT:
            printf("Ctrl-Logoff event\n\n"); 
            return FALSE;

        case CTRL_SHUTDOWN_EVENT:
            printf("Ctrl-Shutdown event\n\n"); 
            return FALSE;

        default: 
            return FALSE;
    } 
}

int main() 
{ 
    if (SetConsoleCtrlHandler(CtrlHandler, TRUE)) 
    {
        printf("Handler set\n");
    }
    else
    {
        printf("Handler not set\n");
    }

    while (1);
}