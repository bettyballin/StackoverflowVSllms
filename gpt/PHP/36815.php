<?php\n$file = 'path/to/your/file.zip';\n\nif (file_exists($file)) {\n    header('Content-Description: File Transfer');\n    header('Content-Type: application/octet-stream');\n    header('Content-Disposition: attachment; filename="'.basename($file).'"');\n    header('Expires: 0');\n    header('Cache-Control: must-revalidate');\n    header('Pragma: public');\n    header('Content-Length: ' . filesize($file));\n    readfile($file);\n    exit;\n}\n?>