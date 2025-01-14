#include <execinfo.h>
#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <string.h> // Added for memset function

void handler(int sig) {
   void *array[10];
   size_t size;

   // get void*'s for all entries on the stack
   size = backtrace(array, 10);

   // print out all the frames to stderr
   fprintf(stderr, "Error: signal %d:\n", sig);
   backtrace_symbols_fd(array, size, STDERR_FILENO);
   exit(1);
}

int main() {
    int *foo = (int*)-1; // make a null pointer

    struct sigaction sa;
    memset(&sa, 0, sizeof(struct sigaction)); // Fixed memset call
    sa.sa_handler = &handler;
    sigfillset(&sa.sa_mask);
    sigaction(SIGSEGV, &sa, NULL); // Set up a signal handler to catch SIGSEGV signals (segmentation fault) and dump the stack backtrace

    printf("%d\n", *foo);     // This will cause a segmentation fault by dereferencing a null pointer.
                                // The handler() function is called which dumps the stack trace to stderr, then exits(1).
}