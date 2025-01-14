<?php\n// Start the session\nsession_start();\n\n// Regenerate session id for security\nsession_regenerate_id(true);\n\n// Configure secure cookie settings\n$sessName = session_name();\n$lifetime = 120 * 60; // Two hours lifetime\n$path = "/yourapp";\n$domain = "example.com";\n$secure = true;\n$httpOnly = true;\n\nsession_set_cookie_params($lifetime, $path, $domain, $secure, $httpOnly);\n\n// Set session lifetime\nini_set('session.gc_maxlifetime', $lifetime);\n?>