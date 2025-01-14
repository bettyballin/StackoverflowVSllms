#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    if (setuid(65534) == -1) { // 65534 is the UID for nobody on many systems
        perror("setuid");
        exit(EXIT_FAILURE);
    }
    
    // Your code here
    while (1);

    return 0;
}