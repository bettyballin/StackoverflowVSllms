// E_ERROR: syntax error\nsyntax_error_here();\n\n// E_WARNING: using an unset variable\necho $unset_variable;\n\n// E_PARSE: syntax error\nparse_error_here = ' syntax error';\n\n// E_NOTICE: using an uninitialized variable\necho $uninitialized_variable;\n\n// E_STRICT: using a deprecated function\ndeprecated_function_here();