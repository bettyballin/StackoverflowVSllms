#include <php.h>

// Define the TestPassRef function
PHP_FUNCTION(TestPassRef) {
    // Implement your function logic here
    php_printf("TestPassRef function called.\n");
}

// Define the my_functions array
const zend_function_entry my_functions[] = {
    PHP_FE(TestPassRef, NULL)
    PHP_FE_END
};

// Module initialization function
PHP_MINIT_FUNCTION(my_module) {
    return SUCCESS;
}

// Module shutdown function
PHP_MSHUTDOWN_FUNCTION(my_module) {
    return SUCCESS;
}

// Module activation function
PHP_RINIT_FUNCTION(my_module) {
#if defined(COMPILE_DL_MY_MODULE) && defined(ZTS)
    ZEND_TSRMLS_CACHE_UPDATE();
#endif
    return SUCCESS;
}

// Module deactivation function
PHP_RSHUTDOWN_FUNCTION(my_module) {
    return SUCCESS;
}

// Module info function
PHP_MINFO_FUNCTION(my_module) {
    php_info_print_table_start();
    php_info_print_table_header(2, "my_module support", "enabled");
    php_info_print_table_end();
}

// Zend module entry
zend_module_entry my_module_module_entry = {
    STANDARD_MODULE_HEADER,
    "my_module",
    my_functions,
    PHP_MINIT(my_module),
    PHP_MSHUTDOWN(my_module),
    PHP_RINIT(my_module),
    PHP_RSHUTDOWN(my_module),
    PHP_MINFO(my_module),
    PHP_VERSION,
    STANDARD_MODULE_PROPERTIES
};

#ifdef COMPILE_DL_MY_MODULE
ZEND_DLEXPORT zend_module_entry *get_module(void) {
    return &my_module_module_entry;
}
#endif