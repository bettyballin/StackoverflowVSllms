#include <stdio.h>

// Define the context types
typedef enum {
    KERNEL,
    USER
} context_t;

// Define the IRQ dispatch function
void dispatch(int irq) {
    // IRQ dispatch implementation...
    printf("Dispatching IRQ %d\n", irq);
}

// Define the context switching functions
void switch_to_context(context_t context, void (*func)(int)) {
    // Switch to context implementation...
    printf("Switching to %s context\n", context == KERNEL ? "KERNEL" : "USER");
    func(0); // Call the dispatch function with IRQ 0
}

void switch_back_context() {
    // Switch back to previous context implementation...
    printf("Switching back to previous context\n");
}

int main() {
    // Define the IRQ number
    int irq = 0;

    // Switch to KERNEL context and invoke interrupt handler
    switch_to_context(KERNEL, dispatch);

    // Interrupt handling code...
    printf("Handling interrupt...\n");

    // Switch back to previous context
    switch_back_context();

    return 0;
}