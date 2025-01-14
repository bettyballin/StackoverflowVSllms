<?php\nsession_start(); // Start session at the beginning\n\n// Ensure the $_SESSION['colorcode'] is set before using it in setcookie()\nif (isset($_SESSION['colorcode'])) {\n    $colorCode = htmlspecialchars($_SESSION['colorcode'], ENT_QUOTES, 'UTF-8');\n    \n    // Set cookies with proper handling\n    if (setcookie(\n        'colorcode',\n        $colorCode,\n        time() + 60 * 60 * 24 * 30, // Cookie lasts for 1 month\n        '/',                      // Path on the server where the cookie will work\n        '',                       // Domain\n        false,                    // Secure - set to true if using HTTPS\n        true                      // HTTPOnly - prevents JavaScript from accessing this cookie\n    )) {\n        echo "Cookie has been set successfully.";\n    } else {\n        echo "Failed to set cookie.";\n    }\n} else {\n    echo "No color code found in session.";\n}\n?>