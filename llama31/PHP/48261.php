if (!file_exists('/path/to/httpsdocs/nav.php')) {\n    symlink('/path/to/httpdocs/nav.php', '/path/to/httpsdocs/nav.php');\n}