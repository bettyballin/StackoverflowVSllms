// Search for .txt files in the current working directory\nforeach (glob("*.txt") as $filename) {\n    echo "$filename size " . filesize($filename) . "\n";\n}\n\n// Search for .txt files in a specific directory\nforeach (glob("/path/to/directory/*.txt") as $filename) {\n    echo "$filename size " . filesize($filename) . "\n";\n}