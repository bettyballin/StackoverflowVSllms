#include <limits.h>

int find_smallest(int a, int b, int c) {
    int min = INT_MAX;

    if (a > 0 && a < min) {
        min = a;
    }
    if (b > 0 && b < min) {
        min = b;
    }
    if (c > 0 && c < min) {
       min = c;
    }

    return min == INT_MAX ? 0 : min;
}

int main() {
    // You can test the function here, for example:
    int a = 5, b = 3, c = 8;
    int smallest = find_smallest(a, b, c);
    return 0;
}