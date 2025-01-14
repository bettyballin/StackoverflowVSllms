#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    // At a suitable point, check heap
    if (1) { // HeapLeakCheckerIsActive is not a standard C function, so I replaced it with a constant
        int pid = fork();
        if (pid == 0) {
            execl("/path/to/heapchecker", "heapchecker", "--show_bytes=32", (char *) NULL);
        }
    }
    return 0;
}