#include <stdio.h>

void insert_asm() {
    asm __volatile__ (".byte 0x12");
}

int main() {
    insert_asm();
    return 0;
}