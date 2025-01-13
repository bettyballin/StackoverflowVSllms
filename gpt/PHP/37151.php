function exception_handler($exception) {\n       if ($exception instanceof UserErrorException) {\n           // Handle user errors (e.g., log, display user-friendly message)\n           error_log($exception->getMessage());\n           // Redirect to a 404 error page or show a custom error message\n           header("HTTP/1.0 404 Not Found");\n           include '404.php';\n           exit();\n       } elseif ($exception instanceof FrameworkErrorException) {\n           // Handle framework errors (e.g., log, display a technical error message)\n           error_log($exception->getMessage());\n           // Show a generic error page for the framework errors\n           include 'error.php';\n           exit();\n       } else {\n           // Handle other exceptions\n           error_log($exception->getMessage());\n           include 'error.php';\n           exit();\n       }\n   }\n   set_exception_handler('exception_handler');