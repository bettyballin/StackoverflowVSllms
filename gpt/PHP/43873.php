$directory = '/path/to/your/directory';\n\nif (is_writable($directory)) {\n    echo "The directory is writable.";\n} else {\n    echo "The directory is not writable.";\n}