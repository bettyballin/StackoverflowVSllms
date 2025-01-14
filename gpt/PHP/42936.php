<?php\n// Example PHP encryption using Triple DES\nfunction encrypt($data, $key, $iv) {\n    return openssl_encrypt($data, 'des-ede3-cbc', $key, OPENSSL_RAW_DATA, $iv);\n}\n\n$key = '123456789012345678901234';  // 24-byte key for Triple DES\n$iv = '12345678';  // 8-byte IV for CBC mode\n\n$plaintext = 'Hello, World!';\n$ciphertext = encrypt($plaintext, $key, $iv);\n\n// Encode the ciphertext in base64 to safely transmit as a string\necho base64_encode($ciphertext);\n?>