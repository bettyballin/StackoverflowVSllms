// Set the cookie with a specific path and secure flag\nsetcookie("hello", true, [\n    'expires' => time() + 3600,\n    'path' => '/',\n    'domain' => '', // Set your domain here\n    'secure' => isset($_SERVER['HTTPS']),\n    'httponly' => true,\n    'samesite' => 'Lax' // 'Strict' or 'None' can also be used depending on your need\n]);\n\n// Check if the cookie is set\nif (isset($_COOKIE['hello'])) {\n    echo "yes";\n    exit;\n} else {\n    // Redirect to the login form\n    header("Location: login_form.php");\n    exit;\n}