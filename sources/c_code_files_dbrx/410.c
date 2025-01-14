#include <linux/init.h>
#include <linux/kernel.h>  /* printk */
#include <linux/module.h>  // for init_module and cleanup_module

/* For static reference to original function */
static void (*original_function_reference)(void);
extern void (*internal_function)(void); /* Original function pointer in the kernel */

// New implementation of internal_function() that will replace the one provided by module
static void new_implementation(void) {
    // Perform your customized functionality here.
}

/* Module initializing part as per standard */
static int __init my_module_init(void) {
   printk(KERN_ALERT "loading my_module driver\n"); /* output text string to the system log */
   // Saving original function pointer before modifying it with our new implementation
   original_function_reference = internal_function;
   // Now overriding original function pointer with a reference to your own implementation.
   // * Note: This will directly affect calls to `internal_function()` in the kernel!
   internal_function = &new_implementation;
   return 0; // Non-zero value would signal an error during initialization of this module.
}

/* Module cleanup part as per standard */
static void __exit my_module_exit(void) {
  printk(KERN_ALERT "exit my_module driver\n"); /* output text string to the system log */
  internal_function = original_function_reference; // Restore original function on cleaning and remove module
}

module_init(my_module_init);
module_exit(my_module_exit);