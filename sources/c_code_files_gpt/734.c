#include <stdio.h>
#include <unistd.h>

int main() {
    for (int i = 0; i <= 100; i++) {
        printf("\rProgress: %d%%", i);
        fflush(stdout); // Ensure the output is displayed immediately
        usleep(100000); // Sleep for 100 milliseconds
    }
    printf("\n");
    return 0;
}