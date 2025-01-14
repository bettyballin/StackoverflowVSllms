#include <stdlib.h>
#include <unistd.h>

int main()
{
    // Your code here

    // Use exit to terminate the process
    _exit(0); // or exit(0) for a more conventional exit that calls atexit handlers

    return 0; // This will not be reached
}