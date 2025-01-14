#include <stdio.h>

int main() {
    int a;
    int b;
    double c;
    int p = 10; // assigning some value to p for demonstration
    int *ptr = &p; // creating a pointer to p

    a = -5;    //'a = -5' or 'a =- 5'?
    b = *ptr;    //'b = *p' or 'b =* p'?
    c = 0.5;    //'c = .5' or 'c =. 5'?

    printf("a = %d\n", a);
    printf("b = %d\n", b);
    printf("c = %f\n", c);

    return 0;
}