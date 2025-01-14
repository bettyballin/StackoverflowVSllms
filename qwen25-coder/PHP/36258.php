<?php\n$filePath = 'path/to/your/image.jpg';\nif (file_exists($filePath)) {\n    header('Content-Type: image/jpeg');\n    header('Content-Length: ' . filesize($filePath));\n    header('Content-Disposition: inline; filename="' . basename($filePath) . '"');\n    readfile($filePath);\n} else {\n    http_response_code(404);\n    echo "File not found.";\n}\n?>