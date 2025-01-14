<?php\n// Set a custom exception handler\nset_exception_handler('exception_handler');\n\nfunction exception_handler($exception) {\n    // Format the exception message\n    $message = sprintf(\n        "[%s] Uncaught exception: '%s' in %s:%d\nStack trace:\n%s\n",\n        date('Y-m-d H:i:s'),\n        $exception->getMessage(),\n        $exception->getFile(),\n        $exception->getLine(),\n        $exception->getTraceAsString()\n    );\n\n    // Log the message to a file\n    error_log($message, 3, '/path/to/your/logfile.log');\n\n    // Optionally, display a generic error message to the user\n    echo "An unexpected error occurred. Please try again later.";\n}\n\n// Example usage: throwing an uncaught exception\nthrow new Exception('This is an uncaught exception.');\n?>