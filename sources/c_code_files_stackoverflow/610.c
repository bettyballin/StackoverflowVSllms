#include <stdio.h>

typedef enum { false = 0, true = 1 } bool;

#define FOR(i, iterator) auto bool lambda(i); yield_init = (bool (*)(i))&lambda; iterator; bool lambda(i)
#define DO {
#define YIELD(x) if (!yield(x)) return
#define BREAK return false
#define CONTINUE return true
#define OD CONTINUE; }
/* Warning: _Most_ FOR(,){ } loops _must_ have a CONTINUE as the last statement.
 *  *   Otherwise the lambda will return random value from stack, and may terminate early */

typedef void iterator; /* hint at procedure purpose */
static volatile bool (*yield_init)(int);
#define YIELDS(type) bool (*yield)(type) = (bool (*)(type))yield_init

iterator fibonacci(int n) {
    YIELDS(int);
    int i;
    int pair[2] = { 0, 1 };
    YIELD(0);
    YIELD(1);
    for (i = 2; i < n; i++) {
        pair[i % 2] = pair[0] + pair[1];
        YIELD(pair[i % 2]);
    }
}

iterator factors(int n) {
    YIELDS(int);
    int i;
    for (i = 2; i * i <= n; i++) {
        while (n % i == 0) {
            YIELD(i);
            n /= i;
        }
    }
    YIELD(n);
}

int main() {
    FOR (int i, fibonacci(32)) {
        printf("%d:", i);
        int sum = 0;
        FOR (int factor, factors(i)) {
            sum += factor;
            printf(" %d", factor);
            CONTINUE;
        }
        printf(" - sum of factors: %d\n", sum);
        CONTINUE;
    }
    return 0;
}