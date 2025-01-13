set_error_handler('custom_error_handler', E_ALL);\n\nfunction custom_error_handler($errno, $errstr, $errfile, $errline) {\n    if (preg_match('/^ibase_/', $errstr)) {\n        trigger_error('ibase_* functions are deprecated. Please use our custom wrapper instead.', E_USER_NOTICE);\n    }\n}