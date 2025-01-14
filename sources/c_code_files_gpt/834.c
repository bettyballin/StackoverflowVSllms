#include <stdio.h>

// Function prototypes
void foo1(char* p1);
char* foo2(void);

int main()
{
    char* p = NULL;

    foo1(p);
    foo2();

    return 0;
}

void foo1(char* p1)
{
}

char* foo2(void)
{
    char* p2 = NULL;

    return p2;
}