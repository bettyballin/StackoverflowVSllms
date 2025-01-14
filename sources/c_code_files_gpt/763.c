#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/types.h>
#include <linux/math64.h> // Include this for int_sqrt function

static int __init my_module_init(void)
{
    printk(KERN_INFO "Loading my module...\n");

    // Example of using kernel's math functions
    unsigned int x = 16;
    unsigned int result = int_sqrt(x);
    
    printk(KERN_INFO "The square root of %u is %u\n", x, result);

    return 0;
}

static void __exit my_module_exit(void)
{
    printk(KERN_INFO "Unloading my module...\n");
}

module_init(my_module_init);
module_exit(my_module_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Your Name");
MODULE_DESCRIPTION("A simple example of using math functions in a kernel module");