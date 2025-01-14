<?php\nfunction decrypt($key1, $key2, $key3, $iv, $token) {\n    // Use the first 8 bytes of each key to form a 24-byte key for 3DES\n    $key = substr($key1, 0, 8) . substr($key2, 0, 8) . substr($key3, 0, 8);\n\n    $td = mcrypt_module_open('tripledes', '', 'cbc', ''); \n    $iv = substr($iv, 0, mcrypt_enc_get_iv_size($td)); \n    $expected_key_size = mcrypt_enc_get_key_size($td); \n\n    // Ensure the key size matches what is expected by mcrypt\n    if (strlen($key) != $expected_key_size) {\n        throw new Exception("Invalid key length");\n    }\n\n    mcrypt_generic_init($td, $key, $iv);\n    $decrypted_string = trim(mdecrypt_generic($td, hex2bin($token))); // Assuming the token is in hex format\n\n    mcrypt_generic_deinit($td); \n    mcrypt_module_close($td); \n\n    return $decrypted_string;\n}\n\n// Usage\n$key1 = '1234567890123456';\n$key2 = '6543210987654321';\n$key3 = '6549873210456123';\n$ivec = '0102030405060708';\n$token = '2ad82e09e3b4e7c491e4bb9fb7c606e1';\n\necho decrypt($key1, $key2, $key3, $ivec, $token);\n?>