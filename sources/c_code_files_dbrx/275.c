#include "php.h"

zend_class_entry *my_ce;
zend_object_handlers my_handlers;

void my_free_storage(zend_object *object) {
  // Free any allocated resources here or leave empty if not needed
}

void my_clone(zval *object) {}

HashTable *my_get_properties(zval *object) {
  return &((myClass *)((char *)object - XtOffsetOf(myClass, std)))->properties;
}

PHP_MINIT_FUNCTION(MyExtension) {
    zend_class_entry ce;

    memcpy(&my_handlers, zend_get_std_object_handlers(), sizeof(zend_object_handlers));
    my_handlers.offset = XtOffsetOf(myClass, std);
    my_handlers.free_obj = my_free_storage;
    my_handlers.clone_obj = my_clone;
    my_handlers.get_properties = my_get_properties;

    INIT_NS_CLASS_ENTRY(ce, "MyNamespace", "MyClass", NULL);
    my_ce = zend_register_internal_class(&ce TSRMLS_CC);

    // Add int property (just an example)
    zend_declare_property_long(my_ce, "intProp", sizeof("intProp")-1, 42, ZEND_ACC_PUBLIC TSRMLS_DC);

    return SUCCESS;
}

PHP_METHOD(MyClass, __construct) {
    zval *pThis = getThis();
    zval *myArray;

    MAKE_STD_ZVAL(myArray);
    array_init(myArray);

    // Assign the array as a public property
    if (zend_declare_property(my_ce, "MyMemberArray", sizeof("MyMemberArray")-1, myArray, ZEND_ACC_PUBLIC TSRMLS_CC) == FAILURE) {
        zval_dtor(myArray);
        efree(myArray);
    } else {
        zend_update_property(my_ce, pThis, "MyMemberArray", sizeof("MyMemberArray")-1, myArray TSRMLS_CC);
        zval_add_ref(&myArray);
    }
}

// Add this function to make the module work with PHP
zend_module_entry MyExtension_module_entry = {
    STANDARD_MODULE_HEADER,
    "MyExtension",
    NULL,                  /* Functions */
    PHP_MINIT(MyExtension),        /* MINIT */
    NULL,                  /* MSHUTDOWN */
    NULL,                  /* RINIT */
    NULL,                  /* RSHUTDOWN */
    NULL,                  /* MINFO */
    NO_VERSION_YET,       /* Replace with version number for your extension */
    STANDARD_MODULE_PROPERTIES
};

#ifdef COMPILE_DL_MyExtension
ZEND_DLEXPORT
#endif
zend_module_entry *get_module(void) {
    return &MyExtension_module_entry;
}