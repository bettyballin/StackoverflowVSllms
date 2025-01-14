#include <stdio.h>

// Define the struct s type
typedef struct s s;
// Define a function pointer type that takes struct s as an argument and returns void
typedef void (*func_t)(s _this);

// Define the structure s with a function pointer and an integer
struct s {
    func_t method;
    int dummy_member;
};

// Define a function that matches the func_t type
void a_method(s _this) {
    printf("Executing a_method with dummy_member value: %d\n", _this.dummy_member);
}

int main() {
    // Create an instance of struct s
    s my_struct;
    // Assign the function a_method to the method pointer in my_struct
    my_struct.method = a_method;
    // Assign a value to the dummy_member for demonstration
    my_struct.dummy_member = 42;
    
    // Call the method through the function pointer
    my_struct.method(my_struct);

    return 0;
}