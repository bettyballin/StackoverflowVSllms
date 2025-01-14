<?php\n// On sub1.example.com, set a cookie when user is authenticated\nsetcookie("SSOCookie", $token, [\n    'expires' => time() + 86400,\n    'secure' => true, // Use HTTPS\n    'httponly' => true,\n    'samesite' => 'None',\n    'domain' => '.example.com'\n]);\n?>