<?php\n\n// Function to roll multiple PHP files into one\nfunction rollFiles($files, $outputFile) {\n    $rolledContent = '';\n    \n    foreach ($files as $file) {\n        $content = file_get_contents($file);\n        if ($content === false) {\n            echo "Error reading file: $file\n";\n            continue;\n        }\n        $rolledContent .= "\n// Content of file: $file\n" . $content . "\n";\n    }\n\n    file_put_contents($outputFile, $rolledContent);\n}\n\n// Example usage\n$phpFilesToRoll = [\n    'lib/config.php',\n    'lib/database.php',\n    'lib/session.php'\n];\n\nrollFiles($phpFilesToRoll, 'all.php');\n\n?>