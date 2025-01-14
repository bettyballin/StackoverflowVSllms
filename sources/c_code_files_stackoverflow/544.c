#include <stdlib.h>
#include <string.h>

struct foo {
    int a;
    int b;
};

int func(struct foo *x, struct foo *y)
{
    return memcmp(x, y, sizeof (struct foo));
}

int main()
{
    struct foo x = {1, 2};
    struct foo y = {1, 2};
    return func(&x, &y);
}