#include <linux/module.h>
#include <linux/kernel.h>

extern void (*function_ptr)(void); // External declaration of the function pointer

static void new_function(void) {
    // New implementation
    printk(KERN_INFO "New function called\n");
}

static void (*original_function_ptr)(void); // To store the original function pointer

static int __init my_module_init(void) {
    // Save the original function pointer and replace it
    original_function_ptr = function_ptr;
    function_ptr = new_function;
    printk(KERN_INFO "Module initialized\n");
    return 0;
}

static void __exit my_module_exit(void) {
    // Restore the original function pointer
    function_ptr = original_function_ptr;
    printk(KERN_INFO "Module exited\n");
}

module_init(my_module_init);
module_exit(my_module_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Your Name");
MODULE_DESCRIPTION("A module to override a kernel function");