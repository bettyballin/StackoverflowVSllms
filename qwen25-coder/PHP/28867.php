<?php\n   if (!function_exists('imap_open')) {\n       die('IMAP functions are not available');\n   }\n   echo 'IMAP is enabled';