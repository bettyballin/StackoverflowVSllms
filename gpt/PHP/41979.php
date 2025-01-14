<?php\n// Check if file exists and then send it to the client\n$file = 'path/to/your/file.pdf';\n\nif (file_exists($file)) {\n    header('Content-Description: File Transfer');\n    header('Content-Type: application/pdf');\n    header('Content-Disposition: attachment; filename="' . basename($file) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($file));\n    flush(); // Flush system output buffer\n    readfile($file);\n    exit;\n} else {\n    http_response_code(404);\n    echo "File not found!";\n}\n?>