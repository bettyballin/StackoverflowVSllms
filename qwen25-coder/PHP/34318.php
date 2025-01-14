<?php\nsession_start();\n\n// Check if the user is logged in\nif (!isset($_SESSION['logged_in']) || $_SESSION['logged_in'] !== true) {\n    header('HTTP/1.0 403 Forbidden');\n    die('Access denied.');\n}\n\n$file = urldecode($_GET['file']);\n\n// Define allowed file types (security measure)\n$allowed_types = ['mp4', 'mp3'];\n\n// Check if the file type is permitted\n$type = pathinfo($file, PATHINFO_EXTENSION);\nif (!in_array($type, $allowed_types)) {\n    header('HTTP/1.0 403 Forbidden');\n    die('Access denied.');\n}\n\n// Define the full path to the protected file\n$protected_dir = '/your-root-directory/protected_files/';\n$file_path = $protected_dir . basename($file);\n\nif (file_exists($file_path)) {\n    // Check if the file is actually there\n    $size = filesize($file_path);\n    \n    header('Content-Description: File Transfer');\n    header('Content-Type: application/octet-stream');\n    header('Content-Disposition: inline; filename="' . basename($file) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . $size);\n    \n    readfile($file_path);\n    exit;\n} else {\n    header('HTTP/1.0 404 Not Found');\n    die('File not found.');\n}\n?>