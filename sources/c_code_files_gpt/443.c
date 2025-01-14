#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

const char *filePath;

void cleanup() {
    unlink(filePath);
}

void signalHandler(int signum) {
    cleanup();
    exit(signum);
}

void setupCleanup(const char *path) {
    filePath = path;
    atexit(cleanup);
    signal(SIGINT, signalHandler);
    signal(SIGTERM, signalHandler);
}

int main() {
    setupCleanup("test.txt");
    // Simulate some work
    sleep(5);
    return 0;
}