define('FLAG_READ', 1);\ndefine('FLAG_WRITE', 2);\ndefine('FLAG_EXECUTE', 4);\n\n$permissions = FLAG_READ | FLAG_WRITE; // 3\n\nif (($permissions & FLAG_READ) > 0) {\n    echo "Read flag is set.\n";\n}