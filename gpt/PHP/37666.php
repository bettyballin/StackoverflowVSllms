<?php\nfunction xorEncrypt($data, $key) {\n    $keyLength = strlen($key);\n    $output = '';\n\n    for ($i = 0; $i < strlen($data); $i++) {\n        $output .= $data[$i] ^ $key[$i % $keyLength];\n    }\n\n    return $output;\n}\n\nfunction xorDecrypt($data, $key) {\n    // XOR decryption is the same as encryption\n    return xorEncrypt($data, $key);\n}\n\n// Example usage\n$key = 'mysecretkey';\n$data = 'This is a test'; \n\n$encrypted = xorEncrypt($data, $key);\necho "Encrypted: " . bin2hex($encrypted) . "\n"; // Output in hex for readability\n\n$decrypted = xorDecrypt($encrypted, $key);\necho "Decrypted: " . $decrypted . "\n";\n?>