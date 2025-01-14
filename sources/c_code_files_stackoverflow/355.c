#include <unistd.h>
#include <stdio.h>

int main() {
    pid_t sid = setsid();
    if (sid == -1) {
        perror("setsid");
        return 1;
    }

    printf("New session ID: %d\n", sid);
    return 0;
}