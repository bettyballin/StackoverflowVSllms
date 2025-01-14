#include <stdio.h>

struct MyType1 {
    char dummy;
};

typedef struct MyType1* MyType1Handle;

int main() {
    // Create an instance of MyType1
    struct MyType1 myType1Instance;
    myType1Instance.dummy = 'A';

    // Create a handle to the instance
    MyType1Handle handle = &myType1Instance;

    // Access the dummy variable using the handle
    printf("Value of dummy: %c\n", handle->dummy);

    return 0;
}