<?php\n// Define your dynamic cookie name as a string\n$cookieName = "dynamicCookie";\n\n// Value to store in the cookie\n$cookieValue = "This is a test value";\n\n// Set the cookie with dynamically defined name\nsetcookie($cookieName, $cookieValue, time() + (86400 * 30), "/"); // 86400 = 1 day\n\n// Access the cookie using the dynamic name\nif(isset($_COOKIE[$cookieName])) {\n    echo "Cookie '" . htmlspecialchars($cookieName) . "' Value: " . htmlspecialchars($_COOKIE[$cookieName]);\n} else {\n    echo "Cookie not set.";\n}\n?>