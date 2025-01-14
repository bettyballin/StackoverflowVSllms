#include <php.h>

/* {{{ proto string hello_world()
 *    Returns a greeting string
 */
PHP_FUNCTION(hello_world)
{
    RETURN_STRING("Hello, World!", 1);
}
/* }}} */

// Define a module entry point
zend_module_entry hello_module_entry = {
    STANDARD_MODULE_HEADER,
    "hello",
    NULL,  // Function entries
    NULL,  // Module init
    NULL,  // Module shutdown
    NULL,  // Request init
    NULL,  // Request shutdown
    NULL,  // Module info
    NO_VERSION_YET,
    STANDARD_MODULE_PROPERTIES
};

// Define a module init function
PHP_MINIT_FUNCTION(hello)
{
    // Register the hello_world function
    PHP_FUNCTION(hello_world);
    return SUCCESS;
}

// Define a PHP extension module
zend_module_entry *hello_module_ptr;

#ifdef COMPILE_DL_HELLO
ZEND_DLEXPORT
#endif
zend_module_entry *get_module(void)
{
    return &hello_module_entry;
}

int main() {
    // Initialize the PHP interpreter
    sapi_startup(&cgi_sapi_module);
    cgi_sapi_module.php_ini_path_override = NULL;
    cgi_sapi_module.php_ini_ignore = 0;

    // Initialize the module
    hello_module_ptr = get_module();
    hello_module_ptr->module_number = 0;
    hello_module_ptr->module_initialized = 1;

    // Call the module init function
    hello_module_ptr->module_startup_func = PHP_MINIT(hello);
    hello_module_ptr->module_startup_func();

    // Execute the hello_world function
    zval *retval;
    MAKE_STD_ZVAL(retval);
    call_user_function(CG(function_table), NULL, "hello_world", retval, 0, NULL TSRMLS_CC);

    // Print the result
    php_printf("%s\n", Z_STRVAL_P(retval));

    // Clean up
    efree(retval);
    sapi_shutdown();
    return 0;
}