$error_url = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);\necho "The page <strong>$error_url</strong> was not found.";