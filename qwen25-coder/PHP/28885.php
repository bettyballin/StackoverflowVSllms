$command = createDir($somevariable);\n\nif (empty($command)) {\n    echo "Error: Command string is empty.";\n} else {\n    exec($command, $output, $return_var);\n    \n    if ($return_var === 0) {\n        echo implode("\n", $output); // Success\n    } else {\n        echo "Error executing command: " . implode(", ", $output);\n    }\n}