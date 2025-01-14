<?php\nsession_start(); // Ensure sessions are started\n\n$domain = "http://" . $_SERVER['HTTP_HOST'] . "/";\n\nif ($_SESSION['loggedin'] != '1234' && basename($_SERVER['PHP_SELF']) !== 'index.php') {\n    header("Location: " . $domain . "index.php?l=no");\n    exit();\n}\n\n// If logged in, determine if the user is a webmaster or client and redirect accordingly\nif ($_SESSION['loggedin'] == '1234') {\n    // Assuming you have a session variable to distinguish between webmasters and clients\n    if (isset($_SESSION['is_webmaster']) && $_SESSION['is_webmaster'] === true) {\n        header("Location: " . $domain . "webmaster/");\n        exit();\n    } else {\n        header("Location: " . $domain . "clients/");\n        exit();\n    }\n}\n?>