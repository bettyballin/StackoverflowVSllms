#include <stdio.h>

// Define a function pointer type
typedef void (*callback_t)(void);

// Define a function that takes a function pointer as an argument
void somefunc(callback_t callback) {
    // Do something with the callback
    callback();
}

// Define a callback function
void my_callback() {
    printf("Callback function called\n");
}

int main() {
    callback_t callback = my_callback;

    printf("Callback before assigning - %p\n", (void*)callback);
    somefunc(callback);
    printf("Callback after assigning - %p\n", (void*)callback);

    return 0;
}