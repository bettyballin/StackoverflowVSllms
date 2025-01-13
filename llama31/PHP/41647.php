// Example logging function\nfunction log_checkout($message, $data) {\n    $log_file = 'checkout_log.txt';\n    $timestamp = date('Y-m-d H:i:s');\n    $log_entry = "$timestamp - $message - " . json_encode($data) . "\n";\n    file_put_contents($log_file, $log_entry, FILE_APPEND);\n}