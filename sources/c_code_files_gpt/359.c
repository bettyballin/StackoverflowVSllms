#include <stdio.h>

int call_function(const char *name, const char *params) {
    // Function call logic based on signature
    printf("Calling function %s with params %s\n", name, params);
    return 0;
}

int main() {
    call_function("example_function", "param1,param2");
    return 0;
}