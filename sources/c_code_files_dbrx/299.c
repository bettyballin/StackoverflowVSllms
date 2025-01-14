#include <unistd.h>

int main() {
    // critical section code comes here
    sleep(1);   // yield voluntarily for X time
    // remaining code
    return 0;
}