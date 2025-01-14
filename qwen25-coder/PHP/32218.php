function print_var_name(&$var) {\n    $stack = debug_backtrace();\n    // We need the line where print_var_name was called, which is in index 0\n    $line_content = file_get_contents($stack[0]['file']);\n    $lines = explode("\n", $line_content);\n    // Get the specific line from the stack trace\n    $calling_line = $lines[$stack[1]['line'] - 1];\n    \n    preg_match('/\$([a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*)/', $calling_line, $matches);\n    if (isset($matches[1]) && $$matches[1] === $var) {\n        echo $matches[1];\n    }\n}\n\n$FooBar = "a string";\nprint_var_name($FooBar); // Outputs: FooBar