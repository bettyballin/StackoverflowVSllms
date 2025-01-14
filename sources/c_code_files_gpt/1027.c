#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// Example long-running function
void long_running_function(int *terminate) {
    for (int i = 0; i < 100; ++i) {
        if (*terminate) {
            printf("Termination requested, cleaning up...\n");
            // Perform any necessary cleanup here
            break;
        }
        // Simulate work
        printf("Working... %d\n", i);
        sleep(1);
    }
}

int main() {
    int terminate = 0;
    long_running_function(&terminate);
    return 0;
}