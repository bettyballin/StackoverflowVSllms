$input = "hello";\n$integer = filter_var($input, FILTER_VALIDATE_INT);\nif ($integer === false) {\n    // Handle invalid integer case\n}