function prevent_direct_access()\n{\n    if ($_SERVER['REQUEST_URI'] == $_SERVER['PHP_SELF']) {\n        http_response_code(404);\n        include_once('404.php');\n        exit; // stop execution to prevent further processing\n    }\n}