# Set file permissions for PHP scripts\nfind /path/to/your/php/files -type f -name "*.php" -exec chmod 644 {} \;\n\n# Set directory permissions\nfind /path/to/your/php/files -type d -exec chmod 755 {} \;