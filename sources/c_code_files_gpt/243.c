#include <php.h>
#include <zend_API.h>

int main() {
    // Initialize the Zend Engine
    zend_init(0);
    TSRMLS_DC;

    // Call the TestPassRef function
    zval *val;
    MAKE_STD_ZVAL(val);
    ZVAL_STRING(val, "original value", 1);
    TestPassRef(val);

    // Print the modified value
    php_printf("%s\n", Z_STRVAL_P(val));

    // Clean up
    zval_ptr_dtor(&val);
    zend_shutdown(TSRMLS_C);
    return 0;
}

void TestPassRef(zval *val) {
    // Parse parameters (not needed in this case)
    // ZEND_PARSE_PARAMETERS_START(1, 1)
    //     Z_PARAM_ZVAL_EX(val, 1, 0)
    // ZEND_PARSE_PARAMETERS_END();

    // Modify the value
    if (Z_TYPE_P(val) == IS_STRING) {
        zval_dtor(val);
        ZVAL_STRING(val, "changed value", 1);
    }
}