$log_file = '/path/to/your/progress.log';\n\n   function log_progress($message) {\n       global $log_file;\n       file_put_contents($log_file, $message . PHP_EOL, FILE_APPEND);\n   }\n\n   // Example usage\n   log_progress('Starting chunk processing...');\n   // Your chunk processing code\n   log_progress('Finished chunk processing...');