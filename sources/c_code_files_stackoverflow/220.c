#include <stdio.h>

int main()
{
    int list[]={4,7,2,4,1,10,3};
    int n;  // the one int variable

    startsort:
    for (n=0; n< sizeof(list)/sizeof(list[0])-1; ++n)
        if (list[n] > list[n+1]) {
            list[n] ^= list[n+1];
            list[n+1] ^= list[n];
            list[n] ^= list[n+1];
            goto startsort;
        }

    for (n=0; n< sizeof(list)/sizeof(list[0]); ++n)
        printf("%d\n",list[n]);
    return 0;
}