function logToFile($message) {\n    $logFile = '/path/to/your/logfile.log';\n    file_put_contents($logFile, date('Y-m-d H:i:s') . ' - ' . $message . PHP_EOL, FILE_APPEND);\n}