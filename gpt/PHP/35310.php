<?php\n$allowed_domains = ['mylink.com'];\n\n$redirect_url = $_GET['RedirectPage'];\n$parsed_url = parse_url($redirect_url);\n$host = $parsed_url['host'];\n\nif (in_array($host, $allowed_domains)) {\n    header('Location: ' . $redirect_url);\n    exit();\n} else {\n    echo "Invalid redirection URL!";\n}\n?>