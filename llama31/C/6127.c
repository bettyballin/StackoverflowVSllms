#include "php.h"\n\nPHP_FUNCTION(TestPassRef)\n{\n    zval *val;\n\n    if (zend_parse_parameters(ZEND_NUM_ARGS() TSRMLS_CC, "z", &val) == FAILURE) {\n        RETURN_NULL();\n    }\n\n    // Now you can modify the value\n    ZVAL_STRING(val, "new value", 1);\n\n    RETURN_NULL();\n}