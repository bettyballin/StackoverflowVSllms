<?php\n// Get the protocol (http or https)\n$protocol = (!empty($_SERVER['HTTPS']) && $_SERVER['HTTPS'] !== 'off' || $_SERVER['SERVER_PORT'] == 443) ? "https://" : "http://";\n\n// Get the host (e.g., www.example.com)\n$host = $_SERVER['HTTP_HOST'];\n\n// Get the directory path of the current script\n$path = dirname($_SERVER['PHP_SELF']);\n\n// Combine to form the URL\n$url = $protocol . $host . $path;\n\necho $url;\n?>