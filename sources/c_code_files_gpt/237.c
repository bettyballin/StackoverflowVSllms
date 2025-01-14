#include <stdio.h>
#include <unistd.h>

int main() {
    if(fork() == 0) {
        /* child */
        printf("This is the child process.\n");
    } else {
        /* parent */
        printf("This is the parent process.\n");
    }
    return 0;
}