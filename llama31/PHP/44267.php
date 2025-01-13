$file = 'path/to/your/file.csv';\n\n// Detect file encoding\n$encoding = mb_detect_encoding($file, 'UTF-8, ISO-8859-1', true);\necho "Detected encoding: $encoding\n";\n\n// Detect line endings\n$fp = fopen($file, 'r');\n$line = fgets($fp);\n$line_endings = substr($line, -2);\nfclose($fp);\necho "Detected line endings: $line_endings\n";