#include <windows.h>

int main() {
    LARGE_INTEGER frequency, start, end;
    double interval;

    QueryPerformanceFrequency(&frequency);
    QueryPerformanceCounter(&start);

    // code to be measured here

    QueryPerformanceCounter(&end);

    interval = (double)(end.QuadPart - start.QuadPart) / frequency.QuadPart;

    printf("Time: %f seconds\n", interval);

    return 0;
}