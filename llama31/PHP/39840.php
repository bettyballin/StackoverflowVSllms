$files = scandir('/path/to/website');\nforeach ($files as $file) {\n    $file_path = '/path/to/website/' . $file;\n    $contents = file_get_contents($file_path);\n    if (strpos($contents, 'malicious_code') !== false) {\n        echo "Malicious code found in $file_path\n";\n    }\n}