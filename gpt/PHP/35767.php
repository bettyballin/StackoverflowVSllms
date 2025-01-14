<?php\n    $data = "my secret data";\n    $key = "mysecretkey";\n    $cipher = "aes-256-cbc";\n    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length($cipher));\n\n    // Encrypt data\n    $encrypted = openssl_encrypt($data, $cipher, $key, 0, $iv);\n    $encrypted = base64_encode($encrypted . '::' . $iv);\n\n    // Decrypt data\n    list($encrypted_data, $iv) = explode('::', base64_decode($encrypted), 2);\n    $decrypted = openssl_decrypt($encrypted_data, $cipher, $key, 0, $iv);\n\n    echo "Encrypted: " . $encrypted . "\n";\n    echo "Decrypted: " . $decrypted . "\n";\n    ?>