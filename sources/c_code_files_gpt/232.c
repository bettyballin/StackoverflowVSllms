// php_foo.c
#include "php_foo.h"

zend_module_entry foo_module_entry = {
    STANDARD_MODULE_HEADER,
    "foo",
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NO_VERSION_YET,
    STANDARD_MODULE_PROPERTIES
};

#ifdef COMPILE_DL_FOO
ZEND_GET_MODULE(foo)
#endif

// Add a dummy main function to make the code executable
int main() {
    return 0;
}