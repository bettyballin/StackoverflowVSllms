#include <fiu-local.h>
#include <stdio.h>

int main() {
    // Example of using libfiu to simulate a read error
    fiu_enable("posix/io/read", 1, NULL, 0);
    return 0;
}