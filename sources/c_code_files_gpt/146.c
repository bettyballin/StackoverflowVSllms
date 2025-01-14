#include <linux/module.h>
#include <linux/export.h>

// Original kernel file (e.g., tcp_input.c)
static void original_function(void) {
    // do something interesting
}

void (*function_ptr)(void) = original_function;
EXPORT_SYMBOL(function_ptr);

// Add a dummy module initialization function to make it compilable
static int __init my_module_init(void) {
    return 0;
}

// Add a dummy module exit function to make it compilable
static void __exit my_module_exit(void) {
}

module_init(my_module_init);
module_exit(my_module_exit);