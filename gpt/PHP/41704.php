function encrypt($data, $key) {\n    $cipher = "aes-256-cbc";\n    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length($cipher));\n    $encrypted = openssl_encrypt($data, $cipher, $key, 0, $iv);\n    return base64_encode($iv . $encrypted);\n}