if (!isset($_SESSION['initiated'])) {\n    // Regenerate session ID on first request to prevent fixation\n    session_regenerate_id(true);\n    $_SESSION['initiated'] = true;\n}