<?php\n// File serving script\nsession_start();\n\n// Check if the user is logged in and has access\nif (!isset($_SESSION['user_id']) || !user_has_access($_SESSION['user_id'])) {\n    die('Unauthorized access.');\n}\n\n$file_name = $_GET['file'];\n$file_name = preg_replace("/[^a-zA-Z0-9\.\-_]/", "", $file_name); // Sanitize file name\n\n$upload_dir = '/path/to/secure/directory/';\n$file_path = $upload_dir . $file_name;\n\nif (file_exists($file_path)) {\n    header('Content-Description: File Transfer');\n    header('Content-Type: application/octet-stream');\n    header('Content-Disposition: attachment; filename="' . basename($file_path) . '"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($file_path));\n    readfile($file_path);\n    exit;\n} else {\n    die('File not found.');\n}\n\nfunction user_has_access($user_id) {\n    // Implement your logic to check if the user has access to the file\n    return true;\n}\n?>