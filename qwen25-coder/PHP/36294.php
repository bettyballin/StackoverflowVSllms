<?php\n// Set a cookie with HttpOnly flag\n$cookie_name = "user";\n$cookie_value = "JohnDoe";\n$expiration = time() + (86400 * 30); // 86400 = 1 day, 30 days\n\nsetcookie($cookie_name, $cookie_value, $expiration, "/", "", false, true);\n\n// The last parameter 'true' makes the cookie HttpOnly\n?>