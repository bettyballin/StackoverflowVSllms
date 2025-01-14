#include <stdbool.h>

__attribute__((constructor)) void InitFoo() {
    static bool initialized = false;
    if (!initialized) {
        // Actual code goes here...
       initialized = true;
    }
}

int main() {
    // Even though InitFoo will run before main because of the constructor attribute,
    // we still need a main function to compile the code into an executable.
    return 0;
}