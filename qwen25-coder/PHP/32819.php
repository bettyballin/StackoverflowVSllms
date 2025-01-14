function exception_handler($exception) {\n    // Log exception information into a file.\n    $logMessage = "[" . date("Y-m-d H:i:s") . "] " .\n                  "Unhandled Exception: " . \n                  $exception->getMessage() . "\n" .\n                  "Stack Trace:\n" .\n                  $exception->getTraceAsString() . "\n";\n\n    // Path to the log file. Ensure proper permissions are set.\n    $logFile = '/path/to/protected/logs/uncaught-exceptions.log';\n\n    // Write the log message to the log file.\n    file_put_contents($logFile, $logMessage, FILE_APPEND);\n\n    // Optionally output a generic error message or a custom template.\n    echo "An internal error occurred. Please try again later.";\n}\n\n// Set the custom exception handler\nset_exception_handler('exception_handler');