// php_foo.h\n#ifndef PHP_FOO_H\n#define PHP_FOO_H 1\n\n#ifdef ZTS\n#include "TSRM.h"\n#endif\n\n#include "php.h"\n\nextern zend_module_entry foo_module_entry;\n#define phpext_foo_ptr &foo_module_entry\n\n#endif