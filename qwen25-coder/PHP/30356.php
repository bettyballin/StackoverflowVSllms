<?php\nheader('Content-Type: text/plain');\necho "include_path from php.ini:\n";\nsystem('grep include_path /usr/local/lib/php.ini');\n\necho "\nCurrent include_path from ini_get:\n";\necho ini_get('include_path');\n\necho "\nChecking .htaccess in current directory:\n";\nif (file_exists('.htaccess')) {\n    echo file_get_contents('.htaccess');\n} else {\n    echo ".htaccess not found.\n";\n}\n?>