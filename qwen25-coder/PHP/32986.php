<?php\n// Save the current directory\n$originalDirectory = getcwd();\n\ntry {\n    // Change to the DIR directory\n    chdir(__DIR__ . '/DIR');\n    \n    // Include main.php, which will now correctly resolve relative paths\n    include('main.php');\n} finally {\n    // Restore the original directory\n    chdir($originalDirectory);\n}\n?>