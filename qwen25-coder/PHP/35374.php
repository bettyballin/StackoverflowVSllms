<?php\n$interval = 24 * 60 * 60; // 24 hours in seconds\n$logFile = 'last_run_time.txt';\n\n// Check if the log file exists and get its contents\nif (file_exists($logFile)) {\n    $lastRunTime = (int)file_get_contents($logFile);\n} else {\n    $lastRunTime = 0; // If no file, assume it's never run before\n}\n\n$currentTimestamp = time();\n\n// Compare current timestamp with last run time to decide if we should run the task\nif ($currentTimestamp - $lastRunTime >= $interval) {\n    // Run your logic here\n    $fileContent = file_get_contents('http://example.com/yourfile.txt');\n    \n    // Log new run time\n    file_put_contents($logFile, $currentTimestamp);\n}\n?>