function hasParseError($filename) {\n    ob_start();\n    $output = [];\n    // Execute the file with PHP CLI and capture the output\n    exec("php -l " . escapeshellarg($filename), $output, $return_var);\n    ob_end_clean();\n\n    // Check if there is a parse error\n    return $return_var !== 0;\n}\n\n$filename = 'path/to/your/dynamic-file.php';\n\nif (hasParseError($filename)) {\n    echo "There is a syntax error in the file. Regenerate it.\n";\n    // Logic to regenerate your dynamically generated PHP file here.\n} else {\n    include $filename;\n}