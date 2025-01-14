#include <stdio.h>

int main() {
    int foo = 1;
    int bar = 1;
    int baz = 2;
    int qux = 3;
    int quux = 4;
    int result1 = 10;
    int result2 = 20;
    int result3 = 30;
    int result4 = 40;
    int fail_result = -1;
    int result;

    result = (foo == bar)  ? result1 :
             (foo == baz)  ? result2 :
             (foo == qux)  ? result3 :
             (foo == quux) ? result4 : 
                             fail_result;

    printf("Result: %d\n", result);
    return 0;
}