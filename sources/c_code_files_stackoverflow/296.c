#include <stdbool.h>

bool function() {
    /* lots of code */
    return function(); // to avoid warning, a return statement is necessary
}

int main() {
    function();
    return 0;
}