<?php\n$filename = '/path/to/file.jpg';\n$chunkSize = 8192; // 8KB\n\n// Check if the file exists\nif (!file_exists($filename)) {\n    header("HTTP/1.0 404 Not Found");\n    exit;\n}\n\n// Get the file size and MIME type (optional)\n$filesize = filesize($filename);\n$mimeType = mime_content_type($filename);\n\n// Set the headers\nheader('Content-Description: File Transfer');\nheader('Content-Type: ' . $mimeType);\nheader('Content-Disposition: inline; filename="' . basename($filename) . '"');\nheader('Content-Transfer-Encoding: binary');\nheader('Content-Length: ' . $filesize);\n\n// Clear the output buffer\nob_clean();\nflush();\n\n// Open the file and send its content to the output buffer in chunks\n$handle = fopen($filename, 'rb');\nif ($handle) {\n    while (!feof($handle)) {\n        echo fread($handle, $chunkSize);\n        flush(); // Ensure the output buffer is flushed\n    }\n    fclose($handle);\n} else {\n    header("HTTP/1.0 500 Internal Server Error");\n    exit;\n}\n?>