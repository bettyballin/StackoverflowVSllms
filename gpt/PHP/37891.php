<?php\n// processFrom.php\n\nif ($_SERVER['REQUEST_METHOD'] !== 'POST' || !isset($_SERVER['HTTP_REFERER']) || parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST) !== $_SERVER['HTTP_HOST']) {\n    // Access is denied, return a 403 Forbidden response\n    http_response_code(403);\n    exit('Access denied');\n}\n\n// Proceed with your processing code here