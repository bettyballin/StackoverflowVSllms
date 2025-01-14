#include <sys/wait.h>

int main() {
    int status;
    while (waitpid(-1, &status, WNOHANG) > 0);
    return 0;
}