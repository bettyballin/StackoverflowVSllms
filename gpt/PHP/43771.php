function profile($func) {\n    $start = microtime(true);\n    $result = $func();\n    $end = microtime(true);\n    $execution_time = $end - $start;\n    echo "Execution time of " . $func . ": " . $execution_time . " seconds\n";\n    return $result;\n}\n\nfunction exampleFunction() {\n    // Your function code here\n}\n\n// Profile the exampleFunction\nprofile('exampleFunction');