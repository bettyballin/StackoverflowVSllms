<?php\nif (isset($_GET['file'])) {\n    $filePath = urldecode($_GET['file']);\n    \n    if (file_exists($filePath)) {\n        header('Content-Type: application/csv');\n        header('Content-Length: ' . filesize($filePath));\n        header('Content-Disposition: attachment; filename="example.csv"');\n        readfile($filePath);\n        unlink($filePath); // Delete the temporary file after download\n        exit();\n    }\n}\n?>