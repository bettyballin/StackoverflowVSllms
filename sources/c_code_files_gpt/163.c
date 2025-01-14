// In driverB.c
#include <linux/module.h>
#include <linux/init.h> // Add this line to include init.h

// Declare the function exported by driverA
extern void driverA_function(void);

static int __init driverB_init(void) {
    printk(KERN_INFO "driverB: Initializing\n"); // Fixed the print statement
    driverA_function();  // Call the function from driverA
    return 0;
}

static void __exit driverB_exit(void) {
    printk(KERN_INFO "driverB: Exiting\n"); // Fixed the print statement
}

module_init(driverB_init);
module_exit(driverB_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Your Name"); // Add this line to specify the author
MODULE_DESCRIPTION("Driver B"); // Add this line to specify the description