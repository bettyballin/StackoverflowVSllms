<?php\n$email = '';\n$fp = fopen('php://stdin', 'r');\nwhile ($line = fgets($fp)) {\n    $email .= $line;\n}\nfclose($fp);\n\n$parser = mailparse_msg_create();\nmailparse_msg_parse($parser, $email);\n\n$sender = mailparse_msg_get_part($parser, 'from');\n$message = mailparse_msg_get_part($parser, 'body');\n\n// Now you have $sender and $message as PHP variables\necho "Sender: " . $sender . "\n";\necho "Message: " . $message . "\n";\n\nmailparse_msg_free($parser);