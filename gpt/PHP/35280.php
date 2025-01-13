<?php\n// process.php\nset_time_limit(0); // Ensure the script doesn't timeout\n$logFile = 'process.log';\n\n// Simulate a long-running task\nfile_put_contents($logFile, "Process started at " . date('Y-m-d H:i:s') . "\n", FILE_APPEND);\nfor ($i = 0; $i < 600; $i++) {\n    sleep(1); // Simulate work by sleeping for 1 second\n    file_put_contents($logFile, "Log entry at " . date('Y-m-d H:i:s') . "\n", FILE_APPEND);\n}\nfile_put_contents($logFile, "Process ended at " . date('Y-m-d H:i:s') . "\n", FILE_APPEND);\n?>