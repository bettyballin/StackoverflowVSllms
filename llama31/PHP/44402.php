$filename = 'example.txt';\nif (preg_match('/^[a-zA-Z0-9._-]+(\.[a-zA-Z0-9_-]+)$/', $filename)) {\n    echo 'Valid filename!';\n} else {\n    echo 'Invalid filename!';\n}