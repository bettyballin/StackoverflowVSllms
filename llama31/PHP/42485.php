// On the main domain\n$token = bin2hex(random_bytes(16));\nsetcookie('auth_token', $token, time() + 3600, '/');\n\n// On each subdomain\n$token = $_COOKIE['auth_token'];\nif (verify_token($token)) {\n    // User is authenticated\n}