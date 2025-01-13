// In driverB.c\n#include <linux/module.h>\n\n// Declare the function exported by driverA\nextern void driverA_function(void);\n\nstatic int __init driverB_init(void) {\n    printk(KERN_INFO "driverB: Initializing\n");\n    driverA_function();  // Call the function from driverA\n    return 0;\n}\n\nstatic void __exit driverB_exit(void) {\n    printk(KERN_INFO "driverB: Exiting\n");\n}\n\nmodule_init(driverB_init);\nmodule_exit(driverB_exit);\n\nMODULE_LICENSE("GPL");