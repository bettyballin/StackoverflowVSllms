#include <windows.h>

bool isProcessRunning(HANDLE process)
{
   return WaitForSingleObject( process, 0 ) == WAIT_TIMEOUT;
}