<?php\nif (isset($_SERVER['PHP_AUTH_USER'])) {\n    $username = $_SERVER['PHP_AUTH_USER'];\n    echo "Authenticated User: " . htmlspecialchars($username);\n} else {\n    header('WWW-Authenticate: Basic realm="My Realm"');\n    header('HTTP/1.0 401 Unauthorized');\n    echo 'Text to send if user hits Cancel button';\n    exit;\n}\n?>