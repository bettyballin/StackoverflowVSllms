<?php\n$file_path = 'path/to/your/file.txt';\n$file_name = 'file.txt';\n\nheader('Content-Type: application/octet-stream');\nheader('Content-Disposition: attachment; filename="' . $file_name . '"');\nheader('Content-Length: ' . filesize($file_path));\n\nreadfile($file_path);\nexit;