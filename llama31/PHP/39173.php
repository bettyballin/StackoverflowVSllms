$start_time = microtime(true);\n$mysqli->query($query);\n$end_time = microtime(true);\n\n$execution_time = $end_time - $start_time;\necho "Query execution time: $execution_time seconds\n";