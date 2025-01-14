// Example data\n$data = "Sensitive information";\n$encryption_key = openssl_random_pseudo_bytes(16);\n$ivlen = openssl_cipher_iv_length("aes-256-cbc");\n$iv = openssl_random_pseudo_bytes($ivlen);\n\n// Encrypt\n$ciphertext_raw = openssl_encrypt($data, "aes-256-cbc", $encryption_key, $options=0, $iv);\n$encrypted = base64_encode( $iv . $ciphertext_raw );\n\n// Decrypt\n$c = base64_decode($encrypted);\n$iv_dec = substr($c, 0, $ivlen);\n$ciphertext_dec = substr($c, $ivlen);\n$decrypted = openssl_decrypt($ciphertext_dec, "aes-256-cbc", $encryption_key, $options=0, $iv_dec);\n\necho $data === $decrypted ? 'Encryption and decryption successful' : 'Error';