#include <windows.h>

// Define the printSome function
DWORD WINAPI printSome(void* arg) {
    int i = *(int*)arg;
    printf("Thread %d started\n", i);
    return 0;
}

void spawnThread(int i) {
    CreateThread(0, 0, (LPTHREAD_START_ROUTINE)&printSome, (LPVOID)&i, 0, NULL);
}

int main() {
    int i = 1;
    spawnThread(i);
    return 0;
}