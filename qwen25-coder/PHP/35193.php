<?php\n// Path to your PDF file\n$file = 'path/to/your/document.pdf';\n\nif (file_exists($file)) {\n    header('Content-Description: File Transfer');\n    header('Content-Type: application/pdf');\n    header('Content-Disposition: attachment; filename="' . basename($file) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($file));\n    readfile($file);\n    exit;\n} else {\n    // Handle file not found error here\n    echo "File not found.";\n}\n?>