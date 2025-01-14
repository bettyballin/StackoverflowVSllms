#include <sys/mman.h>
#include <stdio.h>

int main() {
    int prot = PROT_READ | PROT_WRITE | PROT_EXEC;
    printf("Protection flags: %d\n", prot);
    return 0;
}