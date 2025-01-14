<?php\n// Example of sanitizing input\n$mxmlFile = escapeshellarg('/path/to/your/file.mxml');\n\n// Path to the fcsh executable\n$fcshPath = escapeshellarg('/path/to/fcsh');\n\n// Command to compile the .mxml file\n$command = "$fcshPath mxmlc $mxmlFile";\n\n// Execute the command\nexec($command, $output, $return_var);\n\n// Check for errors\nif ($return_var !== 0) {\n    // Handle error\n    echo "Error compiling .mxml file";\n} else {\n    // Success\n    echo "Compilation successful";\n    // Output result\n    foreach ($output as $line) {\n        echo $line . "\n";\n    }\n}\n?>