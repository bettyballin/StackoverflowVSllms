#include <sys/wait.h>

int main() {
    for (int i = 0; i <= 100; i++) {
        wait(NULL);
    }
    return 0;
}