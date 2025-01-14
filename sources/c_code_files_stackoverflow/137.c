#include <stdio.h>
#include <assert.h>

int main() {
    char arr[10];
    int iNumFilled1 = scanf("%9s", arr);
    int iNumFilled2 = scanf("%9s", arr);
    assert(iNumFilled1 == 1);
    assert(iNumFilled2 == 1);
    return 0;
}