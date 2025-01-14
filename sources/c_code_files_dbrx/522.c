#include <php.h>
#include <php_main.h>
#include <php_variables.h>
#include <php_output.h>

// Define zend_module_entry struct
zend_module_entry module_entry = { 
    STANDARD_MODULE_HEADER, 
    "my_ext", 
    NULL, 
    ZEND_MINIT(MyExtensionInit), 
    NULL, 
    NULL, 
    NULL, 
    ZEND_MINFO(my_extension_info)
};

// Extension initializer
ZEND_MINIT_FUNCTION(MyExtensionInit)
{
    return SUCCESS;
}

// Function that increments integers by 10.
PHP_FUNCTION(increment_by_ten)
{ 
    zend_long num = 0;
    ZEND_PARSE_PARAMETERS_START(1, 1)
        Z_PARAM_LONG(num)
    ZEND_PARSE_PARAMETERS_END();

    RETURN_LONG(num + 10);
}

ZEND_MINFO_FUNCTION(my_extension_info)
{
    php_info_print_table_start();
    php_info_print_table_row(2, "my_ext", "information");
    php_info_print_table_end();
}

// clang-format off
#ifdef COMPILE_DL_MY_EXT
ZEND_DLEXPORT
#endif
zend_module_entry *get_module(void) {
    return &module_entry;
}
// clang-format on