#include <unistd.h>
#include <stdio.h>

int main() {
    printf("Sleeping for 2 seconds...\n");
    sleep(2); // Sleep for 2 seconds
    printf("Awake!\n");
    return 0;
}