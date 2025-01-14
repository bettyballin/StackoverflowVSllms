#include <stdio.h>

int compiled_function()
{
    int temp1 = 3 - 2; // MINUS node
    int temp2 = temp1 + 5; // PLUS node
    return temp2;
}

int main()
{
    printf("%d\n", compiled_function());
    return 0;
}