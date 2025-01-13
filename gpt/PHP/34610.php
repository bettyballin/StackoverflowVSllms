<?php\n// Start output buffering\nob_start();\n\n// Register a shutdown function\nregister_shutdown_function('handleShutdown');\n\nfunction handleShutdown() {\n    $error = error_get_last();\n    \n    // Check if it's a parse error\n    if ($error && ($error['type'] === E_PARSE)) {\n        // Clear the output buffer\n        ob_end_clean();\n        \n        // Custom error handling logic\n        echo "<h1>Custom Parse Error Handler</h1>";\n        echo "<p>Error: " . $error['message'] . "</p>";\n        echo "<p>File: " . $error['file'] . "</p>";\n        echo "<p>Line: " . $error['line'] . "</p>";\n        \n        // Optionally, you could log the error or take other actions here\n    } else {\n        // Flush the output buffer if no parse error\n        ob_end_flush();\n    }\n}\n\n// Example code with a parse error\nif () {\n?>