// In driverA.c
#include <linux/module.h>
#include <linux/init.h>  // Include init.h for module initialization

void driverA_function(void) {
    // Function implementation
}

EXPORT_SYMBOL(driverA_function);  // Make this function available to other modules

MODULE_LICENSE("GPL");

// Add module initialization and cleanup functions
static int __init driverA_init(void) {
    printk(KERN_INFO "Driver A initialized\n");
    return 0;
}

static void __exit driverA_exit(void) {
    printk(KERN_INFO "Driver A exited\n");
}

module_init(driverA_init);
module_exit(driverA_exit);