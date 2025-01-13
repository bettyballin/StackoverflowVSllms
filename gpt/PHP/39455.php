<?php\n// Configuration\n$proxy_url = 'http://proxy-server-address/path-to-check';\n$timeout = 10; // Timeout in seconds\n\nfunction check_proxy_server($url, $timeout) {\n    $ch = curl_init($url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n    curl_setopt($ch, CURLOPT_TIMEOUT, $timeout);\n\n    $response = curl_exec($ch);\n    $http_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);\n    curl_close($ch);\n\n    if ($http_code == 200 && $response) {\n        return true;\n    } else {\n        return false;\n    }\n}\n\n// Check the proxy server\nif (!check_proxy_server($proxy_url, $timeout)) {\n    // Proxy server is down or unresponsive, send an alert\n    $to = 'your-email@example.com';\n    $subject = 'Proxy Server Alert';\n    $message = 'The proxy server is down or unresponsive.';\n    $headers = 'From: alert@example.com' . "\r\n" .\n               'Reply-To: alert@example.com' . "\r\n" .\n               'X-Mailer: PHP/' . phpversion();\n\n    mail($to, $subject, $message, $headers);\n    // Optionally, you can log the error as well\n    error_log('Proxy server is down or unresponsive.');\n}\n?>