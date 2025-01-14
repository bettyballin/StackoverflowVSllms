#include <windows.h>

void spawnThread(void (*threadName)(int i))
{
    int i;
    CreateThread(0, 0, (LPTHREAD_START_ROUTINE) threadName, (LPVOID)&i, 0, NULL);
}