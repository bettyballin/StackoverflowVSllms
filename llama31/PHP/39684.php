$message = (string) $message; // Ensure $message is a string\nif (mb_strlen($message) <= 7) {\n    echo $actiona;\n} else {\n    echo $actionb;\n}