#include <stdio.h>

struct InitFoo
{
     InitFoo()
     {
         printf("One-time code goes here\n");
         // one-time code goes here
     }
};

void Foo()
{
    static InitFoo i;
}

int main()
{
    Foo();
    return 0;
}