// my_extension.c
#ifdef HAVE_CONFIG_H
#include "config.h"
#endif

#include "php.h"

PHP_FUNCTION(my_hello_world)
{
    php_printf("Hello World from my extension!\n");
}

static zend_function_entry my_extension_functions[] = {
    PHP_FE(my_hello_world, NULL)
    PHP_FE_END
};

zend_module_entry my_extension_module_entry = {
    STANDARD_MODULE_HEADER,
    "my_extension",
    my_extension_functions,
    NULL, NULL, NULL, NULL, NULL,
    NO_VERSION_YET,
    STANDARD_MODULE_PROPERTIES
};

ZEND_GET_MODULE(my_extension)