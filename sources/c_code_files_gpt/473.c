#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Define a function pointer type
typedef int (*func_ptr_t)(int, double);

// Structure to hold registered functions
typedef struct {
    const char *name;
    const char *signature;
    func_ptr_t func_ptr;
} func_registry_t;

#define MAX_FUNCTIONS 10
func_registry_t registry[MAX_FUNCTIONS];
int num_registered = 0;

// Function to register a function
void REG_FUNCTION(func_ptr_t ptr, const char *name, const char *signature) {
    if (num_registered < MAX_FUNCTIONS) {
        registry[num_registered].name = name;
        registry[num_registered].signature = signature;
        registry[num_registered].func_ptr = ptr;
        num_registered++;
    } else {
        printf("Function registry is full.\n");
    }
}

// Example function
int somefunc(int someparam, double another) {
    return 1234;
}

// Function to call a registered function
int call_function(const char *name, const char *params) {
    for (int i = 0; i < num_registered; i++) {
        if (strcmp(registry[i].name, name) == 0) {
            // Extract parameters based on signature
            if (strcmp(registry[i].signature, "i:id") == 0) {
                int int_param;
                double double_param;
                memcpy(&int_param, params, sizeof(int));
                memcpy(&double_param, params + sizeof(int), sizeof(double));
                return registry[i].func_ptr(int_param, double_param);
            }
        }
    }
    printf("Function not found.\n");
    return -1;
}

int main() {
    // Register the function
    REG_FUNCTION(somefunc, "somefunc", "i:id");

    // Prepare parameters
    int someparam = 10;
    double another = 20.5;
    char params[sizeof(int) + sizeof(double)];
    memcpy(params, &someparam, sizeof(int));
    memcpy(params + sizeof(int), &another, sizeof(double));

    // Call the function
    int result = call_function("somefunc", params);
    printf("Result: %d\n", result);

    return 0;
}