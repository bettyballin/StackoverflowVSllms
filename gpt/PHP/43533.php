<?php\n// Encryption function\nfunction encrypt($plaintext, $key) {\n    $cipher = "aes-256-cbc"; // Cipher method\n    $ivlen = openssl_cipher_iv_length($cipher);\n    $iv = openssl_random_pseudo_bytes($ivlen); // Generate a random IV\n    $ciphertext = openssl_encrypt($plaintext, $cipher, $key, 0, $iv);\n    return base64_encode($iv . $ciphertext); // Combine IV and ciphertext and encode it\n}\n\n// Decryption function\nfunction decrypt($ciphertext, $key) {\n    $cipher = "aes-256-cbc"; // Cipher method\n    $ivlen = openssl_cipher_iv_length($cipher);\n    $ciphertext = base64_decode($ciphertext); // Decode base64\n    $iv = substr($ciphertext, 0, $ivlen); // Extract IV from the beginning\n    $ciphertext = substr($ciphertext, $ivlen); // Extract ciphertext\n    return openssl_decrypt($ciphertext, $cipher, $key, 0, $iv);\n}\n\n// Example usage\n$plaintext = "Hello";\n$key = "your-encryption-key"; // Use a secure key here\n$encrypted = encrypt($plaintext, $key);\n$decrypted = decrypt($encrypted, $key);\n\necho "Original: $plaintext\n";\necho "Encrypted: $encrypted\n";\necho "Decrypted: $decrypted\n";\n?>