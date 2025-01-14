#include <php.h>

PHP_FUNCTION(TestPassRef) {
    zval* myVar; // Create a pointer to hold our incoming argument

    if (zend_parse_parameters(ZEND_NUM_ARGS(), "z", &myVar) == FAILURE) {
        RETURN_NULL(); // If parameters are not as expected, return early.
    }

    zval newVal;
    ZVAL_STRING(&newVal, "new value"); // Prepare new value to be assigned

    ZVAL_COPY(myVar, &newVal); // Assign our newValue to the myVar reference (this modifies the original input variable in PHP).
}

zend_function_entry test_functions[] = {
    PHP_FE(TestPassRef, NULL)
    PHP_FE_END
};

zend_module_entry test_module_entry = {
    STANDARD_MODULE_HEADER,
    "test",
    test_functions,
    NULL, NULL, NULL, NULL, NULL,
    NO_VERSION_YET,
    STANDARD_MODULE_PROPERTIES
};

#ifdef COMPILE_DL_TEST
ZEND_DLEXPORT
#endif
zend_module_entry *get_module(void) {
    return &test_module_entry;
}