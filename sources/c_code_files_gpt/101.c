#include <stdio.h>
#include <stdlib.h>

void objc_runtime_assert(const char* file, int line, int expression, const char* func) {
    if (!expression) {
        fprintf(stderr, "Assertion failed: %s, function %s, file %s, line %d.\n", "expression", func, file, line);
        abort();
    }
}

int main() {
    // Example usage:
    objc_runtime_assert(__FILE__, __LINE__, 0, __func__);
    return 0;
}