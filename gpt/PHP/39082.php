$plaintextPassword = 'user_password';\n$encryptionKey = 'your_secret_key';\n$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));\n$encryptedPassword = openssl_encrypt($plaintextPassword, 'aes-256-cbc', $encryptionKey, 0, $iv);\n$encryptedPassword = base64_encode($encryptedPassword . '::' . $iv);