<?php\n\nfunction isEmailValid($email) {\n    // Extract the domain part from the email\n    list($user, $domain) = explode('@', $email);\n\n    // Get the MX records for the domain\n    if (!getmxrr($domain, $mxHosts)) {\n        return false;\n    }\n\n    // Connect to the mail server\n    $connect = @fsockopen($mxHosts[0], 25);\n    if (!$connect) {\n        return false;\n    }\n\n    // HELO the server\n    fputs($connect, "HELO " . $domain . "\r\n");\n    $response = fgets($connect, 1024);\n    if (strpos($response, '250') === false) {\n        fclose($connect);\n        return false;\n    }\n\n    // Mail from\n    fputs($connect, "MAIL FROM: <test@" . $domain . ">\r\n");\n    $response = fgets($connect, 1024);\n    if (strpos($response, '250') === false) {\n        fclose($connect);\n        return false;\n    }\n\n    // RCPT to\n    fputs($connect, "RCPT TO: <" . $email . ">\r\n");\n    $response = fgets($connect, 1024);\n    fclose($connect);\n\n    if (strpos($response, '250') === false) {\n        return false;\n    }\n\n    return true;\n}\n\n// Example usage\n$email = "example@example.com";\nif (isEmailValid($email)) {\n    echo "Email is valid.";\n} else {\n    echo "Email is invalid.";\n}\n?>