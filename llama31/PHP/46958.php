function exception_error_handler($errno, $errstr, $errfile, $errline) {\n    if (error_reporting() & $errno) { // Only convert errors that are currently being reported\n        throw new ErrorException($errstr, 0, $errno, $errfile, $errline);\n    }\n    return false;\n}