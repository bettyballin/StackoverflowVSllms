function xor_cipher($data, $key) {\n    $result = '';\n    for ($i = 0; $i < strlen($data); $i++) {\n        $result .= chr(ord($data[$i]) ^ ord($key[$i % strlen($key)]));\n    }\n    return $result;\n}\n\n// Example usage:\n$variation_id = 123;\n$secret_key = 'your_secret_key_here';\n\n$encrypted_data = xor_cipher((string)$variation_id, $secret_key);\necho "Encrypted data: $encrypted_data\n";\n\n$decrypted_data = xor_cipher($encrypted_data, $secret_key);\necho "Decrypted data: $decrypted_data\n";