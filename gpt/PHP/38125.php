<?php\nif (!isset($_SERVER['PHP_AUTH_USER'])) {\n    header('WWW-Authenticate: Basic realm="My Protected Area"');\n    header('HTTP/1.0 401 Unauthorized');\n    echo 'Text to send if user hits Cancel button';\n    exit;\n} else {\n    if ($_SERVER['PHP_AUTH_USER'] === 'username' && $_SERVER['PHP_AUTH_PW'] === 'password') {\n        echo "Welcome, authenticated user!";\n    } else {\n        header('HTTP/1.0 401 Unauthorized');\n        echo 'Invalid credentials';\n    }\n}\n?>