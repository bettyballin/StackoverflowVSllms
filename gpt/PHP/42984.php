<?php\n// Path to the file\n$file = 'path/to/your/file.zip';\n\n// Check if the file exists\nif (file_exists($file)) {\n    // Set headers to force download\n    header('Content-Description: File Transfer');\n    header('Content-Type: application/octet-stream');\n    header('Content-Disposition: attachment; filename="' . basename($file) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($file));\n    // Read the file and send it to the output buffer\n    readfile($file);\n    exit;\n} else {\n    // Handle the error if the file doesn't exist\n    echo 'File not found.';\n}\n?>