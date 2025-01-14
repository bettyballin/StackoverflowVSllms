#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    int ret;

    // Replace the current process image with a new process image
    ret = execl("/bin/ls", "ls", "-l", (char *)0);

    // execl only returns if there is an error
    if (ret == -1) {
        perror("execl failed");
        return 1;
    }

    return 0;
}