// Example of writing a cross-platform line break to a file\n$logMessage = "This is a log message" . PHP_EOL;\nfile_put_contents("log.txt", $logMessage, FILE_APPEND);