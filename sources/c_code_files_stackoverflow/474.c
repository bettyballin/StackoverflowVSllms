#include <stdio.h>

int main() {
    int var1 = 10;
    int var2 = 20;
    int var3 = 30;
    int var4 = 40;
    int maximum;

    maximum = (var1 > var2 ? var1 : var2) > (var3 > var4 ? var3 : var4) ? 
             (var1 > var2 ? var1 : var2) : 
             (var3 > var4 ? var3 : var4);

    printf("The maximum value is: %d\n", maximum);

    return 0;
}