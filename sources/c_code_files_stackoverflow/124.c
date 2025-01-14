#include <stdlib.h>

typedef struct { 
    int value ; 
} P ;

/* p is a pointer to P */
void doSomethingElse(P * p)
{
   p->value = 32 ;
   p = malloc(sizeof(P)) ; /* Don't bother with the leak */
   p->value = 45 ;
}

void doSomething()
{
   P * p = malloc(sizeof(P)) ;
   p->value = 25 ;

   doSomethingElse(p) ;

   int i = p->value ;
   /* Value of p ? 25 ? 32 ? 45 ? */
   printf("%d\n", i); // print the value to verify
}

int main() {
    doSomething();
    return 0;
}