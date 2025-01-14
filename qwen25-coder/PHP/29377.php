<?php\n// File path on the server\n$filePath = 'path/to/your/file.flv';\n\nif (file_exists($filePath)) {\n    // Set headers to force download\n    header('Content-Description: File Transfer');\n    header('Content-Type: video/x-flv'); // MIME type for FLV files\n    header('Content-Disposition: attachment; filename="' . basename($filePath) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($filePath));\n    \n    // Clear output buffer before reading the file\n    ob_clean();\n    flush();\n\n    // Read the video file and send to client\n    readfile($filePath);\n    exit;\n} else {\n    echo "File not found.";\n}\n?>