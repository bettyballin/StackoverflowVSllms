<?php\nsession_set_cookie_params([\n    'lifetime' => 0,\n    'path' => '/',\n    'domain' => '.mydomain.com', // Adjust as necessary\n    'secure' => true,            // Secure cookie\n    'httponly' => false,         // Necessary for JavaScript access (if needed)\n    'samesite' => 'None'         // Allow cross-site session cookies\n]);\nsession_start();\n?>