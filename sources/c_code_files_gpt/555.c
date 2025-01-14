#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

// Function to handle signals
void signalHandler(int sig) {
    printf("Caught signal %d\n", sig);
    // You can add your own signal handling logic here
    exit(1); // Exit the program
}

int main(int argc, char *argv[]) {
    // Register signal handler for SIGSEGV (segmentation fault) and other signals
    signal(SIGSEGV, signalHandler);
    signal(SIGABRT, signalHandler);
    // Add other signals as needed

    // Your program code goes here

    return 0;
}