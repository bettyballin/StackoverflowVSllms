#include <stdio.h>

// Define the function pointer type
typedef void (*func_t)(struct s _this);

// Define the struct
struct s {
    func_t method;
    int dummy_member;
};

// Define a function that matches the func_t type
void my_function(struct s _this) {
    printf("my_function called with dummy_member: %d\n", _this.dummy_member);
}

int main() {
    // Create an instance of struct s
    struct s my_struct;
    my_struct.method = my_function;
    my_struct.dummy_member = 42;

    // Call the method
    my_struct.method(my_struct);

    return 0;
}