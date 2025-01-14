<?php\n\nfunction encrypt($plaintext, $password = 'your_encryption_key') {\n    // Random bytes are used as the Initialization Vector (IV)\n    $ivlen = openssl_cipher_iv_length("AES-128-CBC");\n    $iv = openssl_random_pseudo_bytes($ivlen);\n\n    // Encrypts the data\n    $ciphertext_raw = openssl_encrypt(\n        $plaintext, \n        "AES-128-CBC", \n        hash('sha256', $password, true), \n        OPENSSL_RAW_DATA,\n        $iv);\n\n    // Hmac it\n    $hmac = hash_hmac('sha256', $ciphertext_raw, hash('sha256', $password, true), true);\n    \n    // Prepends IV and HMAC for storage/further use\n    return base64_encode($iv.$hmac.$ciphertext_raw);\n}\n\nfunction decrypt($encryptedText, $password = 'your_encryption_key') {\n    $c = base64_decode($encryptedText);\n    $ivlen = openssl_cipher_iv_length("AES-128-CBC");\n    $iv = substr($c, 0, $ivlen);\n    $hmac = substr($c, $ivlen, $sha2len=32); // hmac length is 32 bytes\n    $ciphertext_raw = substr($c, $ivlen+$sha2len);\n\n    $calcmac = hash_hmac('sha256', $ciphertext_raw, hash('sha256', $password, true), $as_binary=true);\n    \n    // Check HMAC\n    if (hash_equals($hmac, $calcmac)) {\n        return openssl_decrypt(\n            $ciphertext_raw,\n            "AES-128-CBC",\n            hash('sha256', $password, true),\n            OPENSSL_RAW_DATA,\n            $iv);\n    } else { \n        throw new Exception("Invalid MAC"); // HMAC not correct\n    }\n}\n\n// Example usage:\n$plaintext = "your_password_here";\n$encrypted = encrypt($plaintext);\necho "Encrypted: " . $encrypted . "\n";\n$decrypted = decrypt($encrypted);\necho "Decrypted: " . $decrypted . "\n";\n?>