<?php\nfunction desEncrypt($plaintext, $key) {\n    // Ensure key is 8 bytes long for DES\n    $key = substr(md5($key), 0, 8);\n    return openssl_encrypt($plaintext, 'des-ecb', $key, OPENSSL_RAW_DATA);\n}\n\nfunction desDecrypt($ciphertext, $key) {\n    // Ensure key is 8 bytes long for DES\n    $key = substr(md5($key), 0, 8);\n    return openssl_decrypt($ciphertext, 'des-ecb', $key, OPENSSL_RAW_DATA);\n}\n\n$data = "This is some text";\n$key = "encryptionKey";\n\n$encrypted = desEncrypt($data, $key);\necho "Encrypted: ", base64_encode($encrypted), "\n"; // Display encrypted data in a readable format\n\n$decrypted = desDecrypt($encrypted, $key);\necho "Decrypted: ", $decrypted, "\n";\n?>