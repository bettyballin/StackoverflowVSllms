#include <execinfo.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void signalHandler(int signum) {
    void *array[10];
    size_t size;

    // Get the array of stack frames
    size = backtrace(array, 10);

    // Print the stack trace to stderr
    fprintf(stderr, "Error: signal %d:\n", signum);
    backtrace_symbols_fd(array, size, STDERR_FILENO);
    
    // Optionally write the stack trace to a file for later use
    FILE *file = fopen("stacktrace.log", "w");
    if (file != NULL) {
        backtrace_symbols_fd(array, size, fileno(file));
        fclose(file);
    }

    // Exit the program
    exit(1);
}

int main() {
    signal(SIGSEGV, signalHandler); // Example signal
    return 0;
}