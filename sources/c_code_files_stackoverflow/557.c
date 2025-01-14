#include <stdio.h>

void whatever(int x) {
    // You can add code here to do something with x
    // For now, it just does nothing
}

int main() {
    int count = 2;
    whatever(count);
    printf("%d\n", count);  // count here is CERTAIN to be still 2
    return 0;
}