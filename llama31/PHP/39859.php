<?php\n// Set the username and password for the protected directory\n$username = 'your_username';\n$password = 'your_password';\n\n// Set the URL of the protected content\n$protected_url = 'http://example.com/protected/content.php';\n\n// Check if the user is already authenticated\nif (isset($_SERVER['PHP_AUTH_USER']) && $_SERVER['PHP_AUTH_USER'] == $username && $_SERVER['PHP_AUTH_PW'] == $password) {\n  // If authenticated, redirect to the protected content\n  header('Location: ' . $protected_url);\n  exit;\n} else {\n  // If not authenticated, prompt the user to enter their credentials\n  header('WWW-Authenticate: Basic realm="Protected Area"');\n  header('HTTP/1.0 401 Unauthorized');\n  echo 'You must be authenticated to access this content.';\n  exit;\n}