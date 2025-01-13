<?php\n// index.php\n\n// Example of a simple PHP route\nif ($_SERVER['REQUEST_URI'] == '/home') {\n    home();\n} else {\n    not_found();\n}\n\nfunction home() {\n    echo "Welcome to the Home page!";\n}\n\nfunction not_found() {\n    header("HTTP/1.0 404 Not Found");\n    echo "Page not found!";\n}\n?>