function is_file_pointer($variable) {\n    return is_resource($variable) && get_resource_type($variable) === 'stream';\n}\n\n// Example usage:\n$filePointer = fopen("example.txt", "r");\nif (is_file_pointer($filePointer)) {\n    echo "The variable contains a file pointer.";\n} else {\n    echo "The variable does not contain a file pointer.";\n}\nfclose($filePointer);