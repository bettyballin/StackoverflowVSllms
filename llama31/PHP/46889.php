if (!file_exists('path/to/backups')) {\n    die('Backup directory not found');\n}\nif (!file_exists('path/to/logs')) {\n    die('Log directory not found');\n}