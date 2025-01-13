// Check for whitespace characters outside of PHP tags\nfunction check_whitespace($file) {\n    $content = file_get_contents($file);\n    $content = trim($content);\n    if (substr($content, 0, 5) !== '<?php') {\n        echo "Whitespace found at the beginning of the file.\n";\n    }\n    if (substr($content, -2) !== '?>') {\n        echo "Whitespace found at the end of the file.\n";\n    }\n}\n\n// Example usage\ncheck_whitespace('path/to/your/file.php');