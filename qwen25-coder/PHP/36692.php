<?php\nfunction safeRedirect($url) {\n    // Remove any illegal characters from the URL\n    $url = filter_var(trim($url), FILTER_SANITIZE_URL);\n    \n    // Ensure it starts with http:// or https://\n    if (!preg_match('~^(?:f|ht)tps?://~i', $url)) {\n        $url = 'http://' . $url;\n    }\n    \n    // Validate the URL format\n    if (filter_var($url, FILTER_VALIDATE_URL) === FALSE) {\n        die('Invalid URL');\n    }\n\n    // Redirect safely\n    header("Location: " . htmlspecialchars($url));\n    exit();\n}\n\n// Example usage\n$link = $_GET['link'];\nsafeRedirect($link);\n?>