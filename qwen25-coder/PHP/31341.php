<?php\n\nclass MyExceptionLogger {\n    public static function logException(Exception $exception) {\n        // Format the error message\n        $errorMessage = sprintf(\n            "[%s] %s in %s on line %d",\n            date('c'),\n            $exception->getMessage(),\n            $exception->getFile(),\n            $exception->getLine()\n        );\n\n        // Write to a log file\n        error_log($errorMessage, 3, '/path/to/your/logfile.log');\n    }\n}\n\nset_exception_handler(function(Exception $e) {\n    MyExceptionLogger::logException($e);\n});\n\n// Example of throwing an exception\nfunction riskyFunction() {\n    throw new Exception("Something went wrong!");\n}\n\ntry {\n    riskyFunction();\n} catch (Exception $e) {\n    // Handle specific exceptions if needed\n}\n?>