<?php\n// Method 1: Using php_uname\n$serverName = php_uname('n');\necho "Server Name: " . $serverName . PHP_EOL;\n\n// Method 2: Using gethostname\n$serverName = gethostname();\necho "Server Name: " . $serverName . PHP_EOL;\n?>