<?php\n// Check if JavaScript is enabled or not (simplified version)\nif (!isset($_COOKIE['js_test'])) {\n    // Set a cookie if JS is detected (this would be set by a small inline script on your main page)\n    // Assuming you don't have that, we'll redirect without further checks for demonstration\n    header("Location: en/index.htm");\n    exit();\n}\n?>