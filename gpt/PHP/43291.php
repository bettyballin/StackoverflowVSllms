$start_time = microtime(true);\n\n   // Your code\n\n   $end_time = microtime(true);\n   $execution_time = $end_time - $start_time;\n   error_log("Execution time: " . $execution_time . " seconds");