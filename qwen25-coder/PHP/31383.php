<?php\n// On sub2.example.com, retrieve the token from the cookie\nif (isset($_COOKIE['SSOCookie'])) {\n    $token = $_COOKIE['SSOCookie'];\n    // Validate the token against your server-side mechanism to confirm it's valid and not tampered with.\n}\n?>