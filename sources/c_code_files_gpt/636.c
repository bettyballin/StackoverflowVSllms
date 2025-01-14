#include <stdio.h>
#include <unistd.h>  // For sleep() on Unix-like systems
#ifdef _WIN32
#define SLEEP(seconds) Sleep((seconds) * 1000)
#else
#define SLEEP(seconds) sleep(seconds)
#endif

int main() {
    int fps = 0;
    while (1) {
        printf("\rFPS: %d", fps);
        fflush(stdout);  // Ensure the output is displayed immediately
        fps++;
        SLEEP(1);  // Sleep for 1 second
    }
    return 0;
}