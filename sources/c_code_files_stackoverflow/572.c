#include <stdio.h>

int three_pow(int x) {
    switch(x) {
        case 1: return 3;
        case 2: return 9;
        case 3: return 27;
    }

    int remain  = x % 3,
        recur   = three_pow((x-remain)/3),
        combine = recur * recur * recur;

    switch (remain) {
        case 0:  return combine;
        case 1:  return combine * 3;
        default: return combine * 9;
    }
}

int main() {
    printf("%d\n", three_pow(4));
    return 0;
}