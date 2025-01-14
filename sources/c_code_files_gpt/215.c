// my_module.c remains the same
#include <linux/module.h>
#include <linux/kernel.h>

void (*original_IOLog)(void);

void patched_IOLog(void) {
    // Do nothing
}

static int __init my_module_init(void) {
    original_IOLog = IOLog;
    IOLog = patched_IOLog;
    return 0;
}

static void __exit my_module_exit(void) {
    IOLog = original_IOLog;
}

module_init(my_module_init);
module_exit(my_module_exit);

MODULE_LICENSE("GPL");