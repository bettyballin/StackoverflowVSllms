#include <stdio.h>

extern void reg_read(int nAddr, int *pVal);

void reg_read(int nAddr, int *pVal) {
    // -- read implementation --
    // For demonstration purposes, just assign a value
    *pVal = 0x12345678;
}

void test_read(void) {
    int nRegVal;

    // Dummy checking !!
    reg_read(0x100, &nRegVal);
    printf("Read value: 0x%x\n", nRegVal);
}

int main() {
    test_read();
    return 0;
}