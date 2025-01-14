<?php\n// Start timing at the beginning of your script\n$startTime = microtime(true);\n\n// Your application code here\n\n// End timing at the end of your script\n$endTime = microtime(true);\n$executionTime = $endTime - $startTime;\n\n// Log the execution time if it exceeds a certain threshold (e.g., 2 seconds)\n$logThreshold = 2; // in seconds\nif ($executionTime > $logThreshold) {\n    error_log("Execution Time: " . $executionTime . " seconds for script: " . $_SERVER['PHP_SELF']);\n}\n?>