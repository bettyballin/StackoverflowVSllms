<?php\n// Define the directory where the files are stored\n$directory = '/path/to/your/files/';\n\n// Get the requested file name from the query string\n$file = basename($_GET['file']);\n\n// Sanitize the file name to prevent directory traversal attacks\n$file = preg_replace('/[^a-zA-Z0-9_\.-]/', '', $file);\n\n// Construct the full file path\n$filePath = $directory . $file;\n\n// Check if the file exists\nif (file_exists($filePath) && is_file($filePath)) {\n    // Set headers to force download\n    header('Content-Description: File Transfer');\n    header('Content-Type: application/octet-stream');\n    header('Content-Disposition: attachment; filename="' . basename($filePath) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($filePath));\n    \n    // Read the file and output its content\n    readfile($filePath);\n    exit;\n} else {\n    // File doesn't exist, display an error message\n    echo 'File not found.';\n}\n?>