#include <stdio.h>

int init(void)
{
    return 1;
}

int main()
{
    int result = init();
    printf("%d\n", result);
    return 0;
}