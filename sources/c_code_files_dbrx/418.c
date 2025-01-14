#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

int main() {
    char *argv[] = {"ls", NULL};  // You can add arguments here, e.g., {"ls", "-l", NULL};
    int ret;

    ret = execv("/bin/ls", argv);
    if (ret == -1) {
        perror("exec failed");
    }

    return 0;
}