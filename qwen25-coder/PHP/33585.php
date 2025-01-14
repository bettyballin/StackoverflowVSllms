<?php\n// Define the directory where your files are stored\n$filesDir = '/path/to/your/files/';\n\n// Check if filename parameter is provided\nif (!isset($_GET['file'])) {\n    header("HTTP/1.0 400 Bad Request");\n    echo "File parameter not provided.";\n    exit;\n}\n\n// Get the file name from the query string\n$fileName = basename($_GET['file']);\n\n// Verify that the file exists in the specified directory\nif (file_exists($filesDir . $fileName) && is_file($filesDir . $fileName)) {\n    // Set headers to force download dialog\n    header('Content-Description: File Transfer');\n    header('Content-Type: application/octet-stream');\n    header('Content-Disposition: attachment; filename="' . basename($fileName) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($filesDir . $fileName));\n    \n    // Output the file content\n    readfile($filesDir . $fileName);\n    exit;\n} else {\n    header("HTTP/1.0 404 Not Found");\n    echo "File not found.";\n}\n?>