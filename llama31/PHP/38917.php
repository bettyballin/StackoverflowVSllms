<?php\nsession_start();\n\n// Get file size and uploaded size\n$file_size = $_SESSION['file_size'];\n$uploaded_size = filesize($_SESSION['file_tmp']);\n\n// Return progress data\nheader('Content-Type: application/json');\necho json_encode(array(\n    'total' => $file_size,\n    'uploaded' => $uploaded_size\n));\n?>